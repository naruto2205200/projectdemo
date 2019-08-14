package com.example.demo.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2517:29
 */
public class FileUtil {

    /**
     * 上传基础路径：需要在 properties 文件中配置，服务器的路径
     */
    private static String bastPath;
    @Value("${file.server}")
    public void setBastPath(String bastPath) {
        FileUtil.bastPath = bastPath;
    }
    public static String getBastPath() {
        return FileUtil.bastPath;
    }


    /**
     * 方法描述：根据文件的绝对路径创建一个文件对象
     * @param filePath 文件的绝对路径
     * @return 返回创建的这个文件对象
     */
    private static File createFile(String filePath) throws IOException {
        // 获取文件的完整目录
        String fileDir = FilenameUtils.getFullPath(filePath);
        // 判断目录是否存在，不存在就创建一个目录
        File file = new File(fileDir);
        if (!file.isDirectory()) {
            //创建失败返回null
            if (!file.mkdirs()) {
                throw new IOException("文件目录创建失败...");
            }
        }
        // 判断这个文件是否存在，不存在就创建
        file = new File(filePath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("目标文件创建失败...");
            }
        }
        return file;
    }

    /**
     * 方法描述：判断后缀名是否符合（有必要时添加）
     * @param extName   文件的后缀名
     */
    private static void isContains(String extName) {
        String extension = "doc,docx,excle,excles,jpg";
        // 切割文件扩展名
        String[] exts = StringUtils.split(extension, ",");
        if (ArrayUtils.isNotEmpty(exts)) {
            List<String> extList = Arrays.asList(exts);
            //判断
            if (!extList.contains(extName)) {
                throw new RuntimeException("上传文件的类型只能是：" + extension);
            }
        }
    }
    /**
     * 方法描述：生成文件在的实际的路径
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return
     */
    private static String getServerPath(String filePath,String fileName) {
        //在原文件路径上增加一个日期路径
        String uploadPath = bastPath+filePath+"/"+fileName;
        // 文件分隔符转化为当前系统的格式
        return uploadPath;
    }

    /**
     * 生成一个新的路径
     * @param filePath 文件路径
     * @return
     */
    private static String getFilePath(String filePath){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String temp_str=sdf.format(dt);
//        return FilenameUtils.separatorsToSystem(filePath+"/"+temp_str);
        return filePath+"/"+temp_str;
    }


    /**
     * 生成一个新的文件名 ：UUID
     * @param fileName 原文件名
     * @return
     */
    private static String getSuffix(String fileName){
        //获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        //生成一个新的文件名
        String newName = UUID.randomUUID().toString();
        return newName+"."+suffix;
    }

    /**
     * 单文件上传.
     * @param projectId  项目id
     * @param id    文件id
     * @param pathId    文件目录管理表id
     * @param filePath     文件目录管理表path
     * @param userId 登录人id
     * @param file 上传的文件对象
     * @return
     */
    public static void upload(Long projectId, Long id, Long pathId, String filePath, Long userId, MultipartFile file){
        try {
            // 文件名
            String fileName = file.getOriginalFilename();
            fileTransferTo(projectId,id,pathId,filePath, userId,fileName,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多文件上传
     * @param projectId 项目id
     * @param pathId 文件目录管理表id
     * @param filePath 文件目录管理表path
     * @param userId 登录人id
     * @param files 上传的文件对象集合
     * @return
     */
    public static void multiFileUpload(Long projectId,Long pathId,String filePath,Long userId,List<MultipartFile> files){
        MultipartFile file = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            try {
                // 文件名
                String fileName = file.getOriginalFilename();
                fileTransferTo(projectId, null, pathId, filePath, userId, fileName, file);
            } catch (Exception e) {
                System.out.println("===============第"+ i +"个文件有问题===============");
            }
        }
    }

    /**
     * 上传方法
     * @param projectId
     * @param id
     * @param pathId
     * @param filePath
     * @param userId
     * @param fileName
     * @param file
     * @return
     * @throws IOException
     */
    private static void fileTransferTo(Long projectId, Long id, Long pathId, String filePath, Long userId, String fileName, MultipartFile file ) throws IOException{
        // 文件后缀名
//        String extName = FilenameUtils.getExtension(fileName);
        // 判断文件的后缀名是否符合规则
//        isContains(extName);
        //生成一个新的文件名
        String storageFileName = getSuffix(fileName);
        //新的路径
        String storageFilePath = getFilePath(filePath);
        // 文件的实际路径
        String serverPath = getServerPath(storageFilePath,storageFileName);
        // 创建文件
        File destFile = createFile(serverPath);
        // 保存文件
        file.transferTo(destFile);
    }

    /**
     * 文件下载
     * @param filePath 文件目录管理表path
     * @param fileName 文件名称
     * @param storageFileName 文件在服务器上的名称
     * @param response
     * @return
     */
    public static void downloadFile(String filePath,String fileName,String storageFileName, HttpServletResponse response) {
        if (StringUtils.isNoneBlank(filePath ) && StringUtils.isNoneBlank(fileName) ) {
//           //设置文件路径
            File file = new File(getServerPath(filePath,storageFileName));
            if (file.exists()) {
//                download(file,response);
//                System.out.println("下载成功");
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                OutputStream out = null;
                try {
                    //encode后替换  解决空格问题
                    fileName = URLEncoder.encode(fileName, "utf-8");
                    fileName =StringUtils.replace(fileName,"+", "%20");
                    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
//                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                    response.setContentType("applicatoin/octet-stream");
//                    response.setHeader("UTF-8");
                    out = response.getOutputStream();
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    int i =0;
                    while ((i = bis.read(buffer))!= -1) {
                        out.write(buffer);
                    }
                    out.flush();
                    System.out.println("下载成功");
                }catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void download(File file, HttpServletResponse response) {
        InputStream fis =null;
        OutputStream out =null;
        try {
            // 取得文件名。
            String filename = file.getName();
            // 以流的形式下载文件。
            fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // 清空response
            response.reset();
            // 设置response的Header
            filename = URLEncoder.encode(filename, "utf-8");
            filename =StringUtils.replace(filename,"+", "%20");
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
//            response.addHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 多文件下载（压缩包方式）
     * @param list 文件路径集合
     * @param response
     */
    public static void downLoadFiles(List<String> list, HttpServletResponse response){
        String zipName = System.currentTimeMillis()+".zip";
        BufferedInputStream bis = null;
        ZipOutputStream zos =null;
        try {
            String fileName = null;
            //创建输入流读取文件
            response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
            response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(zipName, "UTF-8"));// 设置在下载框默认显示的文件名
            zos = new ZipOutputStream(response.getOutputStream());
            //循环读取文件路径集合，获取每一个文件的路径
            for(String filePath : list){
                File inputFile = new File(filePath);
                bis = new BufferedInputStream(new FileInputStream(inputFile));
                //截取文件名
                fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
                //将文件写入zip内，即将文件进行打包
                zos.putNextEntry(new ZipEntry(fileName));
                byte[] buffer = new byte[1024];
                int r = 0;
                while ((r = bis.read(buffer)) != -1) {
                    zos.write(buffer, 0, r);
                }
                bis.close();
            }
            fileName = null;
            zos.flush();
            zos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName
     *            要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String filePath,String fileName) {
        String fullPath = getServerPath (filePath ,fileName);
        File file = new File(fullPath);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fullPath + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fullPath);
            else
                return deleteDirectory(fullPath);
        }
    }

    /**
     * 删除单个文件
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

}

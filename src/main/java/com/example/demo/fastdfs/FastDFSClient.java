package com.example.demo.fastdfs;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/2315:06
 */
@Component
public class FastDFSClient {
    private static final Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 上传文件
     * @param file 上传的文件
     * @return
     */
    public FileEntity uploadFile(MultipartFile file){
        FileEntity fileEntity = null;
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            fileEntity = new FileEntity();
            fileEntity.setGroupName(storePath.getGroup());
            fileEntity.setPath(storePath.getPath());
            fileEntity.setFullPath(storePath.getFullPath());
            String fileName = storePath.getPath().substring(storePath.getPath().lastIndexOf('/')+1);
            fileEntity.setFileName(fileName);
        } catch (IOException e) {
            logger.info("上传文件失败，e:{}",e.getMessage());
            e.printStackTrace();
        }
        return fileEntity;
    }


    /**
     * 下载文件
     * @param groupName groupName
     * @param path 上传时返回的path，不是fullpath
     */
    public byte[] downLoadFile(String groupName,String path){
        // 获取文件
        byte[] bytes = fastFileStorageClient.downloadFile(groupName, path, new DownloadByteArray());
        return bytes;
    }

    /**
     * 删除文件
     * @param fileFullPath 文件全路径，上传时返回的fullpath
     */
    public void deleteFile(String fileFullPath){
        try{
            fastFileStorageClient.deleteFile(fileFullPath);
        }catch (Exception e){
            logger.info("删除文件失败，e:{}",e.getMessage());
        }
    }


    /**
     * 上传文件
     * @param fastFile 需要封装FastFile对象，可以指定groupname
     * @return
     */
    public StorePath uploadFile(FastFile fastFile){
        StorePath storePath = null;
        try{
            storePath = fastFileStorageClient.uploadFile(fastFile);
        }catch (Exception e){
            logger.info("上传文件失败，e:{}",e.getMessage());
            e.printStackTrace();
        }
        return storePath;
    }


    /**
     * 上传图片（缩略图）
     * @param fastImageFile
     * @return
     */
    public StorePath uploadImage(FastImageFile fastImageFile){
        StorePath storePath = null;
        try{
            storePath = fastFileStorageClient.uploadImage(fastImageFile);
        }catch (Exception e){
            logger.info("上传文件失败，e:{}",e.getMessage());
            e.printStackTrace();
        }
        return storePath;
    }


}

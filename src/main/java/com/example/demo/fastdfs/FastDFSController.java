package com.example.demo.fastdfs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/2315:09
 */
@Api(value="FastDFS文件上传下载测试")
@RestController
@RequestMapping("/fastdfs")
public class FastDFSController {

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @ApiOperation("文件上传")
    @PostMapping("/uppload")
    public FileEntity test(@RequestParam MultipartFile file){
        FileEntity fileEntity = fastDFSClient.uploadFile(file);
        return fileEntity;
    }

    /**
     * 文件删除
     * @param path 文件全路径，上传时返回的fullpath
     * @return
     */
    @ApiOperation("文件删除")
    @DeleteMapping("/delete")
    public String delete(@ApiParam(name="path",value="文件路径，上传时返回的 fullPath ")
                             @RequestParam String path){
        fastDFSClient.deleteFile(path);
        return "删除成功！";
    }

    /**
     * 文件下载
     * @param groupName
     * @param path 上传时返回的path，不是fullpath
     * @throws IOException
     */
    @ApiOperation("文件下载")
    @GetMapping("/download")
    public byte[] downLoad(@ApiParam(name="groupName",value="上传成功返回的groupName") @RequestParam String groupName,
                         @ApiParam(name="path",value="上传成功返回的path") @RequestParam String path){
        byte[] bytes = fastDFSClient.downLoadFile(groupName,path);
        return bytes;
    }
}

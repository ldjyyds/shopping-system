package com.example.controller;

//文件上传控制器

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//如果商品有需要上传照片的话，可以使用这里。
@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传:{},{},{}",username,age,image);

        //获取原文件名
        String originalFilename=image.getOriginalFilename();

        //构建唯一的文件名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName= UUID.randomUUID().toString()+extname;
        log.info("获取到的新的文件名：{}",newFileName);
        //将文件存储在服务器的磁盘目录当中。
        image.transferTo(new File("E:\\images\\"+newFileName));

        return Result.success();
    }
}

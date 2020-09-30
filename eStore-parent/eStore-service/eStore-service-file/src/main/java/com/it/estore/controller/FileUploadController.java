package com.it.estore.controller;

import com.it.estore.file.FastDFSFile;
import com.it.estore.utils.FastDFSUtils;
import com.it.estore.utils.StatueCode;
import com.it.estore.utils.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileUploadController {

    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "file") MultipartFile file){
        FastDFSFile fastDFSFile = null;
        try {
            fastDFSFile = new FastDFSFile(file.getOriginalFilename(),file.getBytes(), StringUtils.getFilenameExtension(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 调用fastdfs工具方法进行上传
        String[] upload = new String[0];
        try {
            upload = FastDFSUtils.upload(fastDFSFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = null;
        try {
            url = FastDFSUtils.getTrackInfo()+"/"+upload[0]+"/"+upload[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true, StatueCode.SUCCESS_CODE,"文件上传成功",url);
    }
}

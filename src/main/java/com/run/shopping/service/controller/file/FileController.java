package com.run.shopping.service.controller.file;

import com.run.shopping.model.utils.R;
import com.run.shopping.service.service.file.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api(tags="阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R fileOss(@RequestParam("file") MultipartFile file ,@RequestParam("module") String module) throws IOException {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String upload = fileService.upload(inputStream, module, originalFilename);
        return R.ok().data("url",upload).message("文件上传成功");
    }

}

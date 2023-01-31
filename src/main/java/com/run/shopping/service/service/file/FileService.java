package com.run.shopping.service.service.file;

import com.run.shopping.model.utils.R;

import java.io.InputStream;

public interface FileService {

    // 文件上传阿里云服务器
    String upload(InputStream inputStream , String module, String originalFilename);

    void removeFile(String userImg);
}

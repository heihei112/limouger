package com.run.shopping.service.service.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.run.shopping.model.properties.OssProperties;
import com.run.shopping.model.utils.R;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;
    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();
        String endpoint = ossProperties.getEndpoint();

        OSS build = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        if (!build.doesBucketExist(bucketname)){
            // 创建bucket
            build.createBucket(bucketname);
            // 设置oss的权限
            build.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }

        // 构建日期文件
        String folder = new DateTime().toString("yyyy/MM/dd");

        // 文件扩展名
        String filename = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module +"/"+ folder + "/" + filename+fileExtension;

        // 文件上传至阿里云
        build.putObject(ossProperties.getBucketname(),key,inputStream);

        // 关闭阿里云oss

        build.shutdown();


        return "https://" + bucketname + "." + endpoint + "/" + key;
    }

    @Override
    public void removeFile(String userImg) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);

        String host = "https://" + bucketname + "." + endpoint + "/";
        String objectName = userImg.substring(host.length());

        // 删除文件。
        ossClient.deleteObject(bucketname, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
        
    }
}

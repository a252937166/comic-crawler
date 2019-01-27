package com.ouyanglol.crawler.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
public class QiniuUtil {

    private static String accessKey="0j0DJNycJ8YTqLlgh22aKM57vfeAnfsuQy8ZrBDP";
    private static String secretKey="_mj_dSZo93IGCjZ3JpusTNGWDMjfslfgZFWhnNSw";
    private static String bucket="comic";

    public static String uploadImg(String fileName,byte[] fileBytes) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        DefaultPutRet putRet = null;
        try {
            Response response = uploadManager.put(fileBytes, key, upToken);
            //解析上传成功的结果
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                log.error(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return putRet!=null?putRet.key:null;
    }


    public static void uploadImg(String url,String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
//抓取网络资源到空间
        try {
            FetchRet fetchRet = bucketManager.fetch(url, bucket, fileName);
            log.debug(fetchRet.hash);
            log.debug(fetchRet.key);
            log.debug(fetchRet.mimeType);
            log.debug("{}",fetchRet.fsize);
        } catch (QiniuException ex) {
            log.error(ex.response.toString());
        }
    }

    public static String getUrl(String fileName) {
        String domainOfBucket = "http://manhua.ouyanglol.com";
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        Auth auth = Auth.create(accessKey, secretKey);
        //1小时，可以自定义链接过期时间
        long expireInSeconds = 3600;
        return auth.privateDownloadUrl(publicUrl, expireInSeconds);
    }

}
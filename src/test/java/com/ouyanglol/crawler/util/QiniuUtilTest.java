package com.ouyanglol.crawler.util;

import com.qiniu.util.Auth;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QiniuUtilTest {

    @Test
    public void uploadImg() throws UnsupportedEncodingException {
        String fileName = "龙珠超11话_1.jpg";
        String domainOfBucket = "https://comic.ouyanglol.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "0j0DJNycJ8YTqLlgh22aKM57vfeAnfsuQy8ZrBDP";
        String secretKey = "_mj_dSZo93IGCjZ3JpusTNGWDMjfslfgZFWhnNSw";
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }
}
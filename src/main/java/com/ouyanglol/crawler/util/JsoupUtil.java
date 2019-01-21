package com.ouyanglol.crawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class JsoupUtil {
    public static SSLContext context;
    //重置httpsURLConnection的DefaultSSLSocketFactory， 使其生成随机证书
    static {
        try {
            context = SSLContext.getInstance("TLSv1.2");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取doc
     * @param url 网址
     * @return
     */
    public static Document getDoc(String url) {
        try {
            return Jsoup.connect(url).sslSocketFactory(context.getSocketFactory()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

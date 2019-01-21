package com.ouyanglol.crawler.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class QiniuUtilTest {

    @Test
    public void uploadImg() {
        QiniuUtil.uploadImg("http://p1.xiaoshidi.net/2017/08/28151422634724.jpg","龙珠.jpg");
    }
}
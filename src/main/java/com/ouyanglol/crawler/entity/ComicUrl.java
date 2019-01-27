package com.ouyanglol.crawler.entity;

import com.maihaoche.starter.mq.annotation.MQKey;
import lombok.Data;

/**
 * @Author: dnouyang
 * @Date: 2018/12/24 16:46
 */
@Data
public class ComicUrl {
    public ComicUrl(String id,String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    @MQKey
    private String id;
    private String name;
    private String url;
}

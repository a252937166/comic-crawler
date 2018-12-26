package com.ouyanglol.crawler.model;

import java.io.Serializable;

/**
 * comic_home
 * @author 
 */
public class ComicHome implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
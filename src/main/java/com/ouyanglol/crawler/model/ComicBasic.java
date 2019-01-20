package com.ouyanglol.crawler.model;

import lombok.Data;

import java.util.Date;

/**
 * comic_basic
 * @author 
 */
@Data
public class ComicBasic {
    private Integer id;

    /**
     * 漫画名
     */
    private String name;

    /**
     * 漫画作者
     */
    private String author;

    /**
     * 点击量
     */
    private Integer checkNum;

    /**
     * 连载状态 1未完结 -1完结
     */
    private Integer serializeStatus;

    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 状态 1有效 -1 失效
     */
    private Integer status;

    private String introduction;

    /**
     * 封面
     */
    private String cover;

    private Integer typeId;

    private Integer areaId;

    private String crawlerUrl;

}
package com.ouyanglol.crawler.model;

import lombok.Data;

import java.util.Date;

/**
 * comic_content
 * @author ouyang
 */
@Data
public class ComicContent {
    private Integer id;

    private Integer chapterId;

    private String imgUrl;

    private Integer pageNo;

    private Date createDate;

    private Date updateDate;

    private Integer status;

    private String fileName;

    /**
     * 原始地址
     */
    private String originalUrl;

}
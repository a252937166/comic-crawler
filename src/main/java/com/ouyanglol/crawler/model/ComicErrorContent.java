package com.ouyanglol.crawler.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * comic_error_content
 * @author 
 */
@Data
public class ComicErrorContent {
    private Integer id;

    private String chapterId;

    private String imgUrl;

    private Integer pageNo;

    private Date createDate;

    private Date updateDate;

    private Integer version;

    private Integer status;

    private String fileName;

}
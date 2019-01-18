package com.ouyanglol.crawler.model;

import lombok.Data;

import java.util.Date;

/**
 * comic_chapter
 * @author 
 */

@Data
public class ComicChapter {
    private Integer id;

    private Integer basicId;

    private String name;

    private Integer chapterNo;

    private Integer status;

    private String originName;

    private Date createDate;

    private Date updateDate;

    /**
     * 是否在爬取中
     */
    private Integer crawlerStatus;

    /**
     * 1 最新章节
     */
    private Integer newFlag;

}
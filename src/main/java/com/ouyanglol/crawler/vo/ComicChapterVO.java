package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:27
 */
@Data
@ApiModel("漫画章节")
public class ComicChapterVO {
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
    private Boolean crawlerStatus;

    /**
     * 1 最新章节
     */
    private Boolean newFlag;
}

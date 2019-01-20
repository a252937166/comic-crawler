package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:27
 */
@Data
@ApiModel("漫画章节")
public class ComicChapterVO {
    @ApiModelProperty(value = "id",example = "1")
    private Integer id;

    @ApiModelProperty(value = "漫画基本ID",example = "1")
    private Integer basicId;

    @ApiModelProperty("章节名")
    private String name;

    @ApiModelProperty(value = "章节编号",example = "1")
    private Integer chapterNo;

    @ApiModelProperty(value = "状态",example = "0")
    private Integer status;

    @ApiModelProperty("原始名字")
    private String originName;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "爬虫状态",example = "1")
    private Integer crawlerStatus;

    @ApiModelProperty(value = "是否有章节更新",example = "1")
    private Integer newFlag;
}

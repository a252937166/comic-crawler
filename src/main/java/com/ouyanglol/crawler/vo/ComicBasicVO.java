package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author admin
 */
@Data
@ApiModel("漫画基本信息")
public class ComicBasicVO {

    @ApiModelProperty(value = "id",example = "1")
    private Integer id;

    @ApiModelProperty("漫画名")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty(value = "点击量",example = "1")
    private Integer checkNum;

    @ApiModelProperty(value = "连载状态",example = "1")
    private Integer serializeStatus;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "状态",example = "1")
    private Integer status;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("封面")
    private String cover;

    @ApiModelProperty(value = "类别id",example = "1")
    private Integer typeId;

    @ApiModelProperty(value = "地区id",example = "1")
    private Integer areaId;

    @ApiModelProperty("爬虫网址")
    private String crawlerUrl;
}

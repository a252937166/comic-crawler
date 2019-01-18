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

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("漫画名")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("点击量")
    private Integer checkNum;

    @ApiModelProperty("连载状态")
    private Byte serializeStatus;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("更新时间")
    private Date updateDate;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("封面")
    private String cover;

    @ApiModelProperty("类别id")
    private Integer typeId;

    @ApiModelProperty("地区id")
    private Integer areaId;

    @ApiModelProperty("爬虫网址")
    private String crawlerUrl;
}

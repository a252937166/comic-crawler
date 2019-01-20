package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 18:05
 */
@ApiModel("章节分页请求类")
@Data
public class ComicChapterPageRequest {
    @ApiModelProperty(value = "当前页",example = "1")
    private Integer page = 1;
    @ApiModelProperty(value = "页面大小",example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty(value = "基本类ID",example = "1")
    private Integer basicId;
    @ApiModelProperty("关键字")
    private String keyWord;
    @ApiModelProperty(value = "爬虫状态",example = "1")
    private Integer crawlerStatus;
}

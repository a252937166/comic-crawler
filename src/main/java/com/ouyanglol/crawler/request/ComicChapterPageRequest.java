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
    private Integer page = 1;
    private Integer pageSize = 10;
    @ApiModelProperty("基本类ID")
    private Integer basicId;
    @ApiModelProperty("关键字")
    private String keyWord;
    @ApiModelProperty("爬虫状态")
    private Integer crawlerStatus;
}

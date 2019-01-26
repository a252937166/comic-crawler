package com.ouyanglol.crawler.request;

import com.ouyanglol.crawler.entity.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 18:05
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("章节分页请求类")
@Data
public class ComicChapterPageRequest extends Page {
    @ApiModelProperty(value = "基本类ID",example = "1")
    private Integer basicId;
    @ApiModelProperty("关键字")
    private String keyWord;
    @ApiModelProperty(value = "爬虫状态",example = "1")
    private Integer crawlerStatus;
}

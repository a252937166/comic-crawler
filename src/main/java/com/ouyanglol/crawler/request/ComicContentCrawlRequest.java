package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dnouyang
 */
@Data
@ApiModel("内容爬虫请求")
public class ComicContentCrawlRequest {
    @ApiModelProperty("章节ID")
    private Integer chapterId;
}

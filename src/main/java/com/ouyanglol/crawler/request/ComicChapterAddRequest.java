package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dnouyang
 */
@Data
@ApiModel("新增漫画章节")
public class ComicChapterAddRequest {
    @ApiModelProperty(value = "漫画基本ID",example = "1")
    private Integer basicId;
    private String name;
    @ApiModelProperty(value = "漫画章节编号",example = "1")
    private Integer chapterNo;
    private String originName;
    private String crawlerUrl;
    @ApiModelProperty(value = "是否是最新章节",example = "0")
    private Integer newFlag;
}

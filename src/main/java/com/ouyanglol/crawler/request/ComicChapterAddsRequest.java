package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dnouyang
 */
@Data
@ApiModel("批量新增漫画章节")
public class ComicChapterAddsRequest {
    @ApiModelProperty(value = "漫画基本ID",example = "1")
    private Integer basicId;
}

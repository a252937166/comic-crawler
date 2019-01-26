package com.ouyanglol.crawler.request;

import com.ouyanglol.crawler.entity.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComicContentPageRequest extends Page {
    @ApiModelProperty(value = "章节Id",example = "1")
    private Integer chapterId;
}

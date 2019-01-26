package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author dnouyang
 */
@Data
@ApiModel("漫画内容")
public class ComicContentVO {

    private Integer chapterId;

    private String imgUrl;

    private Integer pageNo;

    private String originalUrl;
}

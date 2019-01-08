package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ouyang
 * @date 18/12/26 23:10
 */
@ApiModel("漫画详情地址")
@Data
public class ComicHomeVO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("漫画名")
    private String name;
    @ApiModelProperty("详情主页")
    private String url;
    @ApiModelProperty("爬虫状态")
    private Integer status;
}

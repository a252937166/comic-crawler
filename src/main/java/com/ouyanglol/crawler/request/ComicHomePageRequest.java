package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ouyang
 * @date 18/12/26 23:14
 */
@ApiModel("漫画详情请求")
@Data
public class ComicHomePageRequest {
    @ApiModelProperty(value = "当前页",example = "1")
    private Integer page = 1;
    @ApiModelProperty(value = "页面大小",example = "10")
    private Integer pageSize = 10;
    private String name;
    @ApiModelProperty(value = "状态",example = "1")
    private Integer status;
}

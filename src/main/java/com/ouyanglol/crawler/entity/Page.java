package com.ouyanglol.crawler.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页信息")
public class Page {
    @ApiModelProperty(value = "当前页",example = "1")
    private Integer page = 1;
    @ApiModelProperty(value = "页面大小",example = "10")
    private Integer pageSize = 10;
}

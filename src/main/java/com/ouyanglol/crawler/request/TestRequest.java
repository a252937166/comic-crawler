package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ouyang
 * @date 18/12/23 12:37
 */
@Data
@ApiModel("请求类")
public class TestRequest {
    @ApiModelProperty("姓名")
    private String name;
}

package com.ouyanglol.crawler.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ouyang
 * @date 18/12/23 12:34
 */
@Data
@ApiModel("测试实体类")
public class TestVO {
    @ApiModelProperty("名称")
    private String name;
}

package com.ouyanglol.crawler.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Ouyang
 * @date 18/12/26 23:14
 */
@ApiModel("漫画详情请求")
@Data
public class ComicHomePageRequest {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer status;
}

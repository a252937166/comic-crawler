package com.ouyanglol.crawler.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.request.ComicHomePageRequest;
import com.ouyanglol.crawler.vo.ComicHomeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
@RestController
@RequestMapping("crawler")
@Api(tags = "爬虫")
public class CrawlerController {

    @GetMapping("")
    @ApiOperation()
    public Result<PageInfo<ComicHomeVO>> comicHomePage(ComicHomePageRequest request) {

    }
}

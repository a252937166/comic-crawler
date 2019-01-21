package com.ouyanglol.crawler.controller;

import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.request.ComicContentCrawlRequest;
import com.ouyanglol.crawler.service.ComicContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dnouyang
 */
@RestController
@Api(tags = "爬虫")
@RequestMapping("crawler/comicContent")
public class ComicContentController {

    @Autowired
    private ComicContentService comicContentService;

    @PostMapping("crawl")
    @ApiOperation("爬取漫画内容")
    public Result page(@RequestBody ComicContentCrawlRequest request) {
        comicContentService.crawl(request.getChapterId());
        return Result.success();
    }


}

package com.ouyanglol.crawler.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.request.ComicContentCrawlRequest;
import com.ouyanglol.crawler.request.ComicContentPageRequest;
import com.ouyanglol.crawler.service.ComicContentService;
import com.ouyanglol.crawler.vo.ComicContentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dnouyang
 */
@RestController
@Api(tags = "内容")
@RequestMapping("crawler/comicContent")
public class ComicContentController {

    @Autowired
    private ComicContentService comicContentService;

    @PostMapping("crawl")
    @ApiOperation("爬取漫画内容")
    public Result crawl(@RequestBody ComicContentCrawlRequest request) {
        comicContentService.crawl(request.getChapterId());
        return Result.success();
    }

    @GetMapping("page")
    @ApiOperation("根据章节Id获取爬虫内容")
    public Result<PageInfo<ComicContentVO>> page(ComicContentPageRequest request) {
        PageInfo<ComicContentVO> pageInfo =  comicContentService.getPage(request.getChapterId(),request.getPage(),request.getPageSize());
        return Result.success(pageInfo);
    }


}

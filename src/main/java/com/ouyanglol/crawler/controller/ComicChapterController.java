package com.ouyanglol.crawler.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.request.ComicChapterPageRequest;
import com.ouyanglol.crawler.request.ComicHomePageRequest;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.vo.ComicBasicVO;
import com.ouyanglol.crawler.vo.ComicChapterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:17
 */
@RestController
@RequestMapping("crawler/comicChapter")
@Api(tags = "爬虫")
public class ComicChapterController {

    @Autowired
    private ComicChapterService comicChapterService;

    @GetMapping("page")
    @ApiOperation("分页获取漫画详情地址")
    public Result<PageInfo<ComicChapterVO>> page(ComicChapterPageRequest request) {
        PageInfo<ComicChapterVO> pageInfo = comicChapterService.getPage(request.getPage(),request.getPageSize(),request.getBasicId(),request.getKeyWord(),request.getCrawlerStatus());
        return Result.success(pageInfo);
    }
}

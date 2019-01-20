package com.ouyanglol.crawler.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.entity.ResultStatus;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.request.ComicChapterAddsRequest;
import com.ouyanglol.crawler.request.ComicChapterAddRequest;
import com.ouyanglol.crawler.request.ComicChapterPageRequest;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.vo.ComicChapterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("分页获取漫画章节")
    public Result<PageInfo<ComicChapterVO>> page(ComicChapterPageRequest request) {
        PageInfo<ComicChapterVO> pageInfo = comicChapterService.getPage(request.getPage(),request.getPageSize(),request.getBasicId(),request.getKeyWord(),request.getCrawlerStatus());
        return Result.success(pageInfo);
    }

    @PostMapping("add")
    @ApiOperation("新增漫画章节")
    public Result<Integer> page(@RequestBody  ComicChapterAddRequest request) {
        ComicChapter comicChapter = new ComicChapter();
//        comicChapter.setBasicId(request.getBasicId());
//        comicChapter.setName(request.getName());
//        comicChapter.setOriginName(request.getOriginName());
//        comicChapter.setCrawlerUrl(request.getCrawlerUrl());
//        comicChapter.setChapterNo(request.getChapterNo());
//        comicChapter.setNewFlag(request.getNewFlag());
        Integer result = comicChapterService.add(comicChapter);
        if (result > 1) {
            return Result.success(result);
        }else {
            return Result.error(ResultStatus.ERROR);
        }
    }

    @PostMapping("adds")
    @ApiOperation("根据basicId批量新增")
    public Result page(@RequestBody ComicChapterAddsRequest request) {
        comicChapterService.addByBasicId(request.getBasicId());
        return Result.success(ResultStatus.SUCCESS);

    }
}

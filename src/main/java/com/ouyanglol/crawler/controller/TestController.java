package com.ouyanglol.crawler.controller;

import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.request.TestRequest;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Ouyang
 * @date 18/12/23 11:31
 */
@RestController
@Api(tags = "测试")
@RequestMapping("test")
public class TestController {

    @Autowired
    private ComicChapterService comicChapterService;

    @GetMapping("hello")
    public Result hello() {
        return Result.success("hello");
    }

    @ApiOperation("post测试")
    @PostMapping("vo")
    public Result<TestVO> vo(@RequestBody TestRequest request) {
        TestVO vo = new TestVO();
        vo.setName("hello");
        return Result.success(vo);
    }

    @ApiOperation("comicChapter")
    @PostMapping("comicChapter")
    public Result vo(Integer request) {
        ComicChapter comicChapter = new ComicChapter();
        comicChapter.setUpdateDate(new Date());
        comicChapter.setId(request);
        comicChapterService.update(comicChapter);
        return Result.success();
    }

    @ApiOperation("comicChapter")
    @PostMapping("comicChapter1")
    public Result vo1(Integer chapterId) {
        ComicChapter comicChapter = comicChapterService.queryById(chapterId);
        return Result.success();
    }
}

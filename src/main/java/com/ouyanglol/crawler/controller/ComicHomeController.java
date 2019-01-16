package com.ouyanglol.crawler.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.request.ComicHomePageRequest;
import com.ouyanglol.crawler.service.ComicHomeService;
import com.ouyanglol.crawler.vo.ComicHomeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
@RestController
@RequestMapping("crawler/comicHome")
@Api(tags = "爬虫")
public class ComicHomeController {

    @Autowired
    private ComicHomeService comicHomeService;

    @GetMapping("page")
    @ApiOperation("分页获取漫画详情地址")
    public Result<PageInfo<ComicHomeVO>> page(ComicHomePageRequest request) {
        PageInfo<ComicHomeVO> pageInfo = comicHomeService.getPage(request.getPage(),request.getPageSize(),request.getName(),request.getStatus());
        return Result.success(pageInfo);
    }
}

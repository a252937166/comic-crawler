package com.ouyanglol.crawler.controller;

import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.request.TestRequest;
import com.ouyanglol.crawler.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ouyang
 * @date 18/12/23 11:31
 */
@RestController
@Api(tags = "测试")
@RequestMapping("test")
public class TestController {

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
}

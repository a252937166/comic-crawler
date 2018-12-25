package com.ouyanglol.crawler.config;


import com.ouyanglol.crawler.entity.Result;
import com.ouyanglol.crawler.entity.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 统一异常处理
 * @author Ouyang
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        log.error("系统异常:{}",e.getMessage());
        return Result.error(ResultStatus.ERROR);
    }

}
package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicBasic;
import com.ouyanglol.crawler.vo.ComicBasicVO;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
public interface ComicBasicService {
    PageInfo<ComicBasicVO> getPage(Integer pageNo, Integer pageSize, String name, Integer status);

    Integer add(ComicBasic comicBasic);
}

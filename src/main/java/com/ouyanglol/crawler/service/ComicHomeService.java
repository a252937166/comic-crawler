package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicHome;
import com.ouyanglol.crawler.vo.ComicHomeVO;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
public interface ComicHomeService {
    PageInfo<ComicHomeVO> getPage(Integer pageNo, Integer pageSize, String name,Integer status);

    Integer add(ComicHome comicHome);
}

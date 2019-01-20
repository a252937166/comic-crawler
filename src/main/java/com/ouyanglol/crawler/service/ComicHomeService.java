package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicHome;
import com.ouyanglol.crawler.vo.ComicHomeVO;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
public interface ComicHomeService {

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @param name
     * @param status
     * @return
     */
    PageInfo<ComicHomeVO> getPage(Integer pageNo, Integer pageSize, String name,Integer status);

    /**
     * 新增
     * @param comicHome
     * @return
     */
    Integer add(ComicHome comicHome);
}

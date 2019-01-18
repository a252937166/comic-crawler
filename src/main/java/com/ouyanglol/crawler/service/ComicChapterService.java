package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.vo.ComicChapterVO;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:20
 */
public interface ComicChapterService {

    /**
     * 分页
     * @param keyWord 关键字
     * @param basicId 漫画基本类ID
     * @return
     */
    PageInfo<ComicChapterVO> getPage(Integer page,Integer pageSize, Integer basicId,String keyWord,Integer crawlerStatus);

}

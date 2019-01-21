package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicChapter;
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

    Integer add(ComicChapter comicChapter);

    /**
     * 根据basicId新增章节
     * @param basicId basicId
     */
    void addByBasicId(Integer basicId);

    /**
     * 根据爬虫网址查找
     * @param url 爬虫网址
     * @return
     */
    ComicChapter queryByUrl(String url);

    /**
     * 根据id查询
     * @param id id
     * @return
     */
    ComicChapter queryById(Integer id);

}

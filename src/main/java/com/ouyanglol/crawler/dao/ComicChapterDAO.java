package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicChapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * ComicChapterDAO继承基类
 * @author admin
 */
public interface ComicChapterDAO extends MyBatisBaseDAO<ComicChapter, Integer> {

    /**
     * 获取章节列表
     * @param basicId 基本ID
     * @param keyWord 关键字
     * @param crawlerStatus 爬虫状态
     * @return
     */
    List<ComicChapter> queryByNameAndCrawlerStatus(@Param("basicId") Integer basicId, @Param("keyWord") String keyWord, @Param("crawlerStatus") Integer crawlerStatus);


    /**
     * 根据爬虫网址查找章节信息
     * @param url 网址
     * @return
     */
    @Cacheable(value = "queryChapterByUrl",key = "#url",unless = "#result==null")
    ComicChapter queryByCrawlerUrl(@Param("url")String url);
}
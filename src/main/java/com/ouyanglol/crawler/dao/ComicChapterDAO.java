package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicChapter;
import org.apache.ibatis.annotations.Param;

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


}
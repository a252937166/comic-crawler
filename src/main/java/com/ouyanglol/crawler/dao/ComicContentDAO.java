package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicContent;
import org.apache.ibatis.annotations.Param;

/**
 * ComicContentDAO继承基类
 */
public interface ComicContentDAO extends MyBatisBaseDAO<ComicContent, Integer> {
    /**
     * 根据章节ID查看已经爬去的漫画页数
     * @param chapterId 章节id
     * @return
     */
    Integer selectCrawledNumByChapterId(@Param("chapterId") Integer chapterId);
}
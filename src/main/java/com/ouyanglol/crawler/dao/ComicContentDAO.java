package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ComicContentDAO继承基类
 */
public interface ComicContentDAO extends MyBatisBaseDAO<ComicContent, Integer> {
    /**
     * 根据章节ID查看已经爬去的漫画页数
     * @param chapterId 章节id
     * @return
     */
    Integer countCrawledNumByChapterId(@Param("chapterId") Integer chapterId);

    /**
     * 查找
     * @param comicContent 实体
     * @return
     */
    List<ComicContent> queryBySelective(ComicContent comicContent);
}
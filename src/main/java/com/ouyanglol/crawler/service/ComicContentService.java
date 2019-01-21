package com.ouyanglol.crawler.service;

import com.ouyanglol.crawler.model.ComicContent;

/**
 * @author dnouyang
 */
public interface ComicContentService {

    Integer add(ComicContent comicContent);

    /**
     * 根据章节ID爬取漫画内容
     * @param chapterId
     */
    void crawl(Integer chapterId);
}

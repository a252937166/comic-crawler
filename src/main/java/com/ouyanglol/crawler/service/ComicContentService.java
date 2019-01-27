package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicContent;
import com.ouyanglol.crawler.vo.ComicContentVO;

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

    /**
     * 更新
     * @param comicContent 实体
     * @return
     */
    Integer update(ComicContent comicContent);

    ComicContent queryById(Integer id);

    /**
     * 分页获取漫画内容
     *
     * @param pageSize 分页大小
     * @param page 当前页数
     * @param chapterId 章节id
     * @return
     */
    PageInfo<ComicContentVO> getPage(Integer chapterId, Integer page, Integer pageSize);

    /**
     * 根据id获取图片私有连接
     * @param id 文件id
     * @return
     */
    String getSecretUrl(Integer id);
}

package com.ouyanglol.crawler.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.model.ComicBasic;
import com.ouyanglol.crawler.vo.ComicBasicVO;

/**
 * @author Ouyang
 * @date 18/12/26 22:46
 */
public interface ComicBasicService {
    /**
     * 分页获取
     * @param pageNo 当前页
     * @param pageSize 页面大小
     * @param name 名称
     * @param status 状态
     * @return
     */
    PageInfo<ComicBasicVO> getPage(Integer pageNo, Integer pageSize, String name, Integer status);

    /**
     * 添加
     * @param comicBasic 实体
     * @return
     */
    Integer add(ComicBasic comicBasic);

    /**
     * 根据id查找
     * @param basicId basicId
     * @return
     */
    ComicBasic queryById(Integer basicId);
}

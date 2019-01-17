package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicBasic;

import java.util.List;

/**
 * ComicBasicDAO继承基类
 */
public interface ComicBasicDAO extends MyBatisBaseDAO<ComicBasic, Integer> {
    List<ComicBasic> queryByNameAndStatus(String name, Integer status);
}
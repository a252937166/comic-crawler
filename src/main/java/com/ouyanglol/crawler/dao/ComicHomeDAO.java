package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicHome;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ComicHomeDAO继承基类
 */
public interface ComicHomeDAO extends MyBatisBaseDAO<ComicHome, Integer> {
    /**
     * 查询漫画详情列表
     * @param name 名称
     * @param status 状态
     * @return
     */
    List<ComicHome> queryByNameAndStatus(@Param("name") String name, @Param("status") Integer status);
}
package com.ouyanglol.crawler.dao;

import com.ouyanglol.crawler.model.ComicBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ComicBasicDAO继承基类
 * @author dnouyang
 */
public interface ComicBasicDAO extends MyBatisBaseDAO<ComicBasic, Integer> {

    /**
     * 根据名称和状态或者漫画基本信息
     * @param name
     * @param status
     * @return
     */
    List<ComicBasic> queryByNameAndStatus(@Param("name") String name, @Param("status") Integer status);
}
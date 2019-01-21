package com.ouyanglol.crawler.dao;

import java.io.Serializable;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface MyBatisBaseDAO<Model, PK extends Serializable> {
    Integer deleteByPrimaryKey(PK id);

    Integer insert(Model record);

    Integer insertSelective(Model record);

    Model selectByPrimaryKey(PK id);

    Integer updateByPrimaryKeySelective(Model record);

    Integer updateByPrimaryKey(Model record);
}
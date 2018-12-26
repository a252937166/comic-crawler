package com.ouyanglol.crawler.model;

import java.io.Serializable;
import java.util.Date;

/**
 * comic_basic
 * @author 
 */
public class ComicBasic implements Serializable {
    private Integer id;

    /**
     * 漫画名
     */
    private String name;

    /**
     * 漫画作者
     */
    private String author;

    /**
     * 点击量
     */
    private Integer checkNum;

    /**
     * 连载状态 1未完结 -1完结
     */
    private Byte serializeStatus;

    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 状态 1有效 -1 失效
     */
    private Integer status;

    private String introduction;

    /**
     * 封面
     */
    private String cover;

    private Integer typeId;

    private Integer areaId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public Byte getSerializeStatus() {
        return serializeStatus;
    }

    public void setSerializeStatus(Byte serializeStatus) {
        this.serializeStatus = serializeStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
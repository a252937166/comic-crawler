package com.ouyanglol.crawler.model;

import java.io.Serializable;
import java.util.Date;

/**
 * comic_chapter
 * @author 
 */
public class ComicChapter implements Serializable {
    private Integer id;

    private Integer basicId;

    private String name;

    private Integer chapterNo;

    private Integer status;

    private String originName;

    private Date createDate;

    private Date updateDate;

    /**
     * 是否在爬取中
     */
    private Boolean crawlerStatus;

    /**
     * 1 最新章节
     */
    private Boolean newFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(Integer chapterNo) {
        this.chapterNo = chapterNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
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

    public Boolean getCrawlerStatus() {
        return crawlerStatus;
    }

    public void setCrawlerStatus(Boolean crawlerStatus) {
        this.crawlerStatus = crawlerStatus;
    }

    public Boolean getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(Boolean newFlag) {
        this.newFlag = newFlag;
    }
}
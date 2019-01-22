package com.ouyanglol.crawler.service.impl;

import com.ouyanglol.crawler.config.mq.MqComicProducer;
import com.ouyanglol.crawler.dao.ComicContentDAO;
import com.ouyanglol.crawler.entity.ComicUrl;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.model.ComicContent;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.service.ComicContentService;
import com.ouyanglol.crawler.util.JsoupUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dnouyang
 */
@Service
@Slf4j
public class ComicContentServiceImpl implements ComicContentService {

    @Autowired
    private ComicContentDAO comicContentDAO;
    @Autowired
    private ComicChapterService comicChapterService;
    @Autowired
    private MqComicProducer producer;

    @Override
    public Integer add(ComicContent comicContent) {
        comicContent.setCreateDate(new Date());
        Integer result = comicContentDAO.insert(comicContent);
        if (result > 0) {
            return comicContent.getId();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void crawl(Integer chapterId) {
        ComicChapter comicChapter = comicChapterService.queryById(chapterId);
        String chapterUrl = comicChapter.getCrawlerUrl();
        getImg(chapterUrl,chapterId,comicChapter.getName(),1);
    }

    @Override
    @CacheEvict(value = "queryComicContentById",key = "#id")
    public Integer update(ComicContent comicContent) {
        comicContent.setUpdateDate(new Date());
        return comicContentDAO.updateByPrimaryKeySelective(comicContent);
    }

    @Override
    @Cacheable(value = "queryComicContentById",key = "#id")
    public ComicContent queryById(Integer id) {
        return comicContentDAO.selectByPrimaryKey(id);
    }

    private void getImg(String url,Integer chapterId,String chapterName,Integer pageNo) {
        String pattern = "var\\s+mhurl\\s*=\\s*\"(.*?)\";";
        Pattern r = Pattern.compile(pattern);
        String pattern2 = "<a\\s+href=\"(.*?)\"\\s+class=\"pure-button pure-button-primary\">下一页</a>";
        Pattern r2 = Pattern.compile(pattern2);
        Document doc = JsoupUtil.getDoc(url);
        if (doc != null) {
            String orignUrl = doc.getElementById("readurl").attributes().get("content");
            Matcher m = r.matcher(doc.body().toString());
            if (m.find()) {
                String mhurl = m.group(1);
                String mhss = "p1.xiaoshidi.net";
                String year16 = "2016";
                String year17 = "2017";
                String year18 = "2018";
                String year19 = "2019";
                if (!mhurl.contains(year16) && !mhurl.contains(year17) && !mhurl.contains(year18) && !mhurl.contains(year19)) {
                    mhss = "p0.xiaoshidi.net";
                }
                String http = "http";
                String mhpicurl = http + "://"+mhss+"/"+mhurl;
                if (mhurl.contains(http)) {
                    mhpicurl = mhurl;
                }
                String fileName = chapterName+"_"+pageNo+mhurl.substring(mhurl.lastIndexOf("."));
                ComicContent comicContent = new ComicContent();
                comicContent.setChapterId(chapterId);
                comicContent.setFileName(fileName);
                comicContent.setOriginalUrl(mhpicurl);
                comicContent.setPageNo(pageNo);
                Integer contentId= add(comicContent);
                ComicUrl comicUrl = new ComicUrl(contentId.toString(),fileName,mhpicurl);
                log.info(fileName+":"+mhpicurl);
                log.info("存入队列.....");
                producer.sendMsg(comicUrl);
                Matcher m2 = r2.matcher(doc.body().toString());
                if (m2.find()) {
                    String newUrl = orignUrl + m2.group(1);
                    getImg(newUrl,chapterId,chapterName,pageNo+1);
                } else {
                    ComicChapter comicChapter = new ComicChapter();
                    comicChapter.setId(chapterId);
                    comicChapter.setPages(pageNo);
                    comicChapterService.update(comicChapter);
                }
            }
        }
    }
}

package com.ouyanglol.crawler.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.dao.ComicChapterDAO;
import com.ouyanglol.crawler.model.ComicBasic;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.service.ComicBasicService;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.vo.ComicChapterVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:21
 */
@Service
public class ComicChapterServiceImpl implements ComicChapterService {

    @Autowired
    private ComicChapterDAO comicChapterDAO;
    @Autowired
    private ComicBasicService comicBasicService;

    private final String juan = "卷";

    @Override
    @Cacheable(value = "chapterPage")
    public PageInfo<ComicChapterVO> getPage(Integer pageNo, Integer pageSize, Integer basicId,String keyWord,Integer crawlerStatus) {
        PageHelper.startPage(pageNo,pageSize);
        List<ComicChapter> list = comicChapterDAO.queryByNameAndCrawlerStatus(basicId,keyWord,crawlerStatus);
        List<ComicChapterVO> voList = new ArrayList<>();
        list.forEach(comicChapter -> {
            ComicChapterVO vo = new ComicChapterVO();
            BeanUtils.copyProperties(comicChapter,vo);
            voList.add(vo);

        });
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(voList);
        return pageInfo;
    }

    @Override
    @CacheEvict(value = "chapterPage",allEntries = true)
    public Integer add(ComicChapter comicChapter) {
        comicChapter.setCreateDate(new Date());
        Integer result =  comicChapterDAO.insertSelective(comicChapter);
        if (result > 0) {
            return comicChapter.getId();
        }
        return result;
    }

    @Override
    public void addByBasicId(Integer basicId) {
        ComicBasic comicBasic = comicBasicService.queryById(basicId);
        //获取漫画章节页面
        String basicUrl = comicBasic.getCrawlerUrl();
        //获取漫画名
        String comicName = comicBasic.getName();
        Document doc;
        try {
            doc = Jsoup.connect(basicUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Element> list = doc.getElementsByClass("pure-u-1-2 pure-u-lg-1-4");
        //章节从小到大排序
        Collections.reverse(list);
        list.forEach(e -> {
            Element element = e.child(0);
            String crawlerUrl = basicUrl+element.attributes().get("href");
            //查找数据库有无数据
            if (queryByUrl(crawlerUrl) == null) {
                ComicChapter comicChapter = new ComicChapter();
                comicChapter.setBasicId(basicId);
                //章节名
                String chapterName = element.childNode(0).toString();
                if (chapterName.endsWith(juan)) {
                    comicChapter.setType(2);
                }
                comicChapter.setName(chapterName);
                String pattern = comicName + "[\\u4e00-\\u9fa5_a-zA-Z]*([0-9]+)(卷|章)";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(chapterName);
                if (m.find()) {
                    Integer chapterNo = Integer.valueOf(m.group(1));
                    comicChapter.setChapterNo(chapterNo);
                }
                comicChapter.setCrawlerUrl(crawlerUrl);
                if (list.indexOf(e) == list.size() - 1) {
                    comicChapter.setNewFlag(1);
                }
                add(comicChapter);
            }
        });
    }



    @Override
    public ComicChapter queryByUrl(String url) {
        return comicChapterDAO.queryByCrawlerUrl(url);
    }
}

package com.ouyanglol.crawler.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.dao.ComicChapterDAO;
import com.ouyanglol.crawler.model.ComicBasic;
import com.ouyanglol.crawler.model.ComicChapter;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.vo.ComicBasicVO;
import com.ouyanglol.crawler.vo.ComicChapterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dnouyang
 * @Date: 2019/1/18 17:21
 */
@Service
public class ComicChapterServiceImpl implements ComicChapterService {

    @Autowired
    private ComicChapterDAO comicChapterDAO;

    @Override
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
}

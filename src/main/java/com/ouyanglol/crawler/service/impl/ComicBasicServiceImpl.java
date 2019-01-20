package com.ouyanglol.crawler.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.dao.ComicBasicDAO;
import com.ouyanglol.crawler.model.ComicBasic;
import com.ouyanglol.crawler.service.ComicBasicService;
import com.ouyanglol.crawler.vo.ComicBasicVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dnouyang
 * @Date: 2019/1/8 17:05
 */
@Service
public class ComicBasicServiceImpl implements ComicBasicService {

    @Autowired
    private ComicBasicDAO comicBasicDAO;

    @Override
    public PageInfo<ComicBasicVO> getPage(Integer pageNo, Integer pageSize, String name, Integer status) {
        PageHelper.startPage(pageNo,pageSize);
        List<ComicBasic> list = comicBasicDAO.queryByNameAndStatus(name,status);
        List<ComicBasicVO> voList = new ArrayList<>();
        list.forEach(comicBasic -> {
            ComicBasicVO vo = new ComicBasicVO();
            BeanUtils.copyProperties(comicBasic,vo);
            voList.add(vo);

        });
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(voList);
        return pageInfo;
    }

    @Override
    public Integer add(ComicBasic comicBasic) {
        return comicBasicDAO.insertSelective(comicBasic);
    }

    @Override
    @Cacheable(value = "basicQuery",key = "#basicId")
    public ComicBasic queryById(Integer basicId) {
        return comicBasicDAO.selectByPrimaryKey(basicId);
    }
}

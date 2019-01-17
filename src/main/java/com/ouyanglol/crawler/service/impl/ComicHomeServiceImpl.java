package com.ouyanglol.crawler.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.crawler.dao.ComicHomeDAO;
import com.ouyanglol.crawler.model.ComicHome;
import com.ouyanglol.crawler.service.ComicHomeService;
import com.ouyanglol.crawler.vo.ComicHomeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dnouyang
 * @Date: 2019/1/8 17:05
 */
@Service
public class ComicHomeServiceImpl implements ComicHomeService {

    @Autowired
    private ComicHomeDAO comicHomeDAO;

    @Override
    public PageInfo<ComicHomeVO> getPage(Integer pageNo, Integer pageSize, String name, Integer status) {
        PageHelper.startPage(pageNo,pageSize);
        List<ComicHome> list = comicHomeDAO.queryByNameAndStatus(name,status);
        List<ComicHomeVO> voList = new ArrayList<>();
        list.forEach(comicHome -> {
            ComicHomeVO vo = new ComicHomeVO();
            BeanUtils.copyProperties(comicHome,vo);
            voList.add(vo);

        });
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(voList);
        return pageInfo;
    }

    @Override
    public Integer add(ComicHome comicHome) {
        return comicHomeDAO.insertSelective(comicHome);
    }
}

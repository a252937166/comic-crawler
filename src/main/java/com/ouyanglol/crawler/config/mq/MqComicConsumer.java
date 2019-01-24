package com.ouyanglol.crawler.config.mq;

import com.google.gson.internal.LinkedTreeMap;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import com.ouyanglol.crawler.model.ComicContent;
import com.ouyanglol.crawler.service.ComicChapterService;
import com.ouyanglol.crawler.service.ComicContentService;
import com.ouyanglol.crawler.util.QiniuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Ouyang
 */
@Slf4j
@MQConsumer(topic = "${spring.rocketmq.topic}", consumerGroup = "test_group")
public class MqComicConsumer extends AbstractMQPushConsumer {

    @Autowired
    private ComicContentService comicContentService;
    @Autowired
    private ComicChapterService comicChapterService;

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        if (message instanceof LinkedTreeMap) {
            Integer id = Integer.valueOf((String) ((LinkedTreeMap) message).get("id"));
            String fileName = (String) ((LinkedTreeMap) message).get("name");
            String imgUrl = (String) ((LinkedTreeMap) message).get("url");
            log.info("{}:开始上传",fileName);
            QiniuUtil.uploadImg(imgUrl,fileName);
            ComicContent comicContent = new ComicContent();
            comicContent.setId(id);
            comicContent.setStatus(1);
            comicContent.setImgUrl("https://qiniu.ouyanglol.com/"+fileName);
            comicContentService.update(comicContent);
            log.info("{}:上传完毕",fileName);
            comicContent = comicContentService.queryById(id);
            Integer chapterId = comicContent.getChapterId();
            comicChapterService.checkCrawlerStatus(chapterId);
        }
        return true;
    }
}
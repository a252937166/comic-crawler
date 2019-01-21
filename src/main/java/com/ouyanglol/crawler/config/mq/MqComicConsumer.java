package com.ouyanglol.crawler.config.mq;

import com.google.gson.internal.LinkedTreeMap;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import com.ouyanglol.crawler.model.ComicContent;
import com.ouyanglol.crawler.service.ComicContentService;
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

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        if (message instanceof LinkedTreeMap) {
            String fileName = (String) ((LinkedTreeMap) message).get("fileName");
            String imgUrl = (String) ((LinkedTreeMap) message).get("originalUrl");
            System.out.println("开始上传:"+fileName);
//            QiniuUtil.uploadImg(imgUrl,fileName);
            ComicContent comicContent = new ComicContent();
            comicContent.setFileName(fileName);
//            comicContent.setPageNo();
//            comicContentService.add(comicContent);
            System.out.println(fileName+":上传完毕");
        }
        return true;
    }
}
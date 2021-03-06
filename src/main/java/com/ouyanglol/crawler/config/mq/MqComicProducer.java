package com.ouyanglol.crawler.config.mq;

import com.maihaoche.starter.mq.annotation.MQProducer;
import com.maihaoche.starter.mq.base.AbstractMQProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import com.ouyanglol.crawler.entity.ComicUrl;
import com.ouyanglol.crawler.model.ComicContent;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Ouyang
 */
@MQProducer
public class MqComicProducer extends AbstractMQProducer {
    @Value("${spring.rocketmq.topic}")
    private String topic;
    public void sendMsg (ComicUrl msg) {
        this.syncSend(MessageBuilder.of(msg).tag("comicContent").topic(topic).build());
    }
}
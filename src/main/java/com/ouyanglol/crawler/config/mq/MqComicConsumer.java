package com.ouyanglol.crawler.config.mq;

import com.google.gson.internal.LinkedTreeMap;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import com.ouyanglol.crawler.util.QiniuUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ouyang
 */
@Slf4j
@MQConsumer(topic = "${spring.rocketmq.topic}", consumerGroup = "test_group")
public class MqComicConsumer extends AbstractMQPushConsumer {

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        if (message instanceof LinkedTreeMap) {
            String fileName = (String) ((LinkedTreeMap) message).get("name");
            String url = (String) ((LinkedTreeMap) message).get("url");
            System.out.println("开始上传:"+fileName);
            QiniuUtil.uploadImg(url,fileName);
            System.out.println(fileName+":上传完毕");
        }
        return true;
    }
}
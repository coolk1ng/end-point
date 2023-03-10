package com.coolk1ng.rabbitmq.amqp;

import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.coolk1ng.rabbitmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author coolk1ng
 * @since 2023/3/8 20:56
 */
@RestController
@Slf4j
public class ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/testReturnCallback")
    public void testReturnCallback() {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            log.info("message----:{}", new String(message.getBody()));
            log.info(String.valueOf(i));
            log.info(s);
            log.info(s1);
            log.info(s2);
        });

        User user = new User("username", "password");
        rabbitTemplate.convertAndSend("testExchange","testRoutingKey1",
                MessageBuilder.withBody(JSON.toJSONString(user).getBytes()).setMessageId(UUID.randomUUID().toString()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build(),
                new CorrelationData(UUID.randomUUID().toString()));
        log.info("发送消息成功");
    }
}

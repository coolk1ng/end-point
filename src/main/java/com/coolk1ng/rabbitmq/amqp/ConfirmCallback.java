package com.coolk1ng.rabbitmq.amqp;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.rabbitmq.entity.User;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2023/3/8 20:07
 */
@RestController
@Slf4j
public class ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/testConfirmCallback")
    public void testConfirmCallback() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, s) -> {
            if (ack) {
                System.out.println("接受消息成功" + s + correlationData);
            }else {
                System.out.println("接受消息失败" + s);
            }
        });

        User user = new User("username", "password");
//        rabbitTemplate.convertAndSend("testExchange","testRoutingKey",
//                MessageBuilder.withBody(JSON.toJSONString(user).getBytes()).setMessageId(UUID.randomUUID().toString()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build(),
//                new CorrelationData(UUID.randomUUID().toString()));
        rabbitTemplate.convertAndSend("test_exchange","test_routingKey",
                MessageBuilder.withBody(JSON.toJSONString(user).getBytes()).setMessageId(UUID.randomUUID().toString()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build(),
                new CorrelationData(UUID.randomUUID().toString()));
        log.info("发送消息成功");
    }
}

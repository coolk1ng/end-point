package com.coolk1ng;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.rabbitmq.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.UUID;

/**
 * rabbitmq测试类
 *
 * @author coolk1ng
 * @since 2023/2/10 14:34
 */
public class RabbitMQTest {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMQTest.class);

    @Autowired
    @Qualifier("firstRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

//    @Bean
//    public Queue firstQueue() {
//        return new Queue("test");
//    }

    @Test
    public void test1() {
        for (int i = 0; i < 2; i++) {
            User user = new User("username"+ i, "password" + i);
            rabbitTemplate.convertAndSend("test_exchange","test_routingKey",
                    MessageBuilder.withBody(JSON.toJSONString(user).getBytes()).setMessageId(UUID.randomUUID().toString()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build(),
                    new CorrelationData(UUID.randomUUID().toString()));
            logger.info("第{}次消息发送", i+1);
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 2; i++) {
            User user = new User("username"+ i, "password" + i);
            Message build = MessageBuilder.withBody(JSON.toJSONString(user).getBytes()).build();
            rabbitTemplate.convertAndSend("test", build);
            logger.info("第{}次消息发送", i+1);
        }
    }
}

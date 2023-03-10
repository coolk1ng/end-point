package com.coolk1ng.rabbitmq.amqp;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.rabbitmq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author coolk1ng
 * @since 2022/12/31 15:53
 */
@Component
public class AmqpConsumer {
    private final static Logger logger = LoggerFactory.getLogger(AmqpConsumer.class);

//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test_queue", durable = "true", autoDelete = "false"),
//            exchange = @Exchange(value = "test_exchange"), key = "test_routingKey"))
//    public void receive1(Message message) {
//        String data = new String(message.getBody());
//        User user = JSON.parseObject(data, User.class);
//        logger.info("receive1接收的消息:{}", JSON.toJSONString(user));
//    }
//
//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "hello_queue", durable = "true", autoDelete = "false"),
//            exchange = @Exchange(value = "exchange_test"), key = "hello"))
//    public void receive2(Message message) {
//        String data = new String(message.getBody());
//        User user = JSON.parseObject(data, User.class);
//        logger.info("receive2接收的消息:{}", JSON.toJSONString(user));
//    }

//    @RabbitListener(queuesToDeclare = @Queue(value = "test", durable = "true", autoDelete = "true"))
//    public void receive3(String msg) {
//        logger.info("receive3接收的消息:{}", msg);
//    }

//    @RabbitListener(queues = "test_queue", containerFactory = "firstContainerFactory")
//    public void receive3(Message message) {
//        String data = new String(message.getBody());
//        User user = JSON.parseObject(data, User.class);
//        logger.info("receive3接收的消息:{}", JSON.toJSONString(user));
//    }
//
//    @RabbitListener(queues = "test_queue", containerFactory = "firstContainerFactory")
//    public void receive4(Message message) {
//        String data = new String(message.getBody());
//        User user = JSON.parseObject(data, User.class);
//        logger.info("receive4接收的消息:{}", JSON.toJSONString(user));
//    }

}

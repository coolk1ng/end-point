package com.coolk1ng.redis.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 消费redis消息
 *
 * @author coolk1ng
 * @since 2023/6/8 13:24
 */
@Component
@Slf4j
public class RedisConsumer implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        log.info("consumer1消息:{}", body);
    }
}

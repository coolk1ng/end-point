package com.coolk1ng.redis.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author coolk1ng
 * @since 2023/6/8 13:58
 */
@Component
@Slf4j
public class RedisConsumer2 implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        log.info("consumer2消息:{}", body);
    }
}

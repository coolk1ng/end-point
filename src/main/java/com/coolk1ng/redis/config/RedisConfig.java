package com.coolk1ng.redis.config;

import com.alibaba.fastjson2.support.spring.data.redis.FastJsonRedisSerializer;
import com.coolk1ng.redis.consumer.RedisConsumer;
import com.coolk1ng.redis.consumer.RedisConsumer2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * Redis配置
 *
 * @author coolk1ng
 * @since 2023/3/31 10:22
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }


    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(RedisConsumer redisConsumer) {
        return new MessageListenerAdapter(redisConsumer);
    }

    @Bean
    public MessageListenerAdapter getMessageListenerAdapter1(RedisConsumer2 redisConsumer) {
        return new MessageListenerAdapter(redisConsumer);
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                List<MessageListenerAdapter> listenerAdapterList) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        listenerAdapterList.forEach(item -> container.addMessageListener(item, new ChannelTopic("redis_message_channel")));
        return container;
    }
}

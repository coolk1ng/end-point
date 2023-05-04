package com.coolk1ng.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author coolk1ng
 * @since 2023/3/31 10:48
 */
@RestController
@Slf4j
public class RedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/testRedis")
    public void testRedis() {
        redisTemplate.opsForValue().set("key1", "value1");
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 2);

        Jedis jedis = (Jedis) Objects.requireNonNull(stringRedisTemplate.getConnectionFactory()).getConnection().getNativeConnection();
        jedis.decr("int");

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", map);
        stringRedisTemplate.opsForHash().put("hash", "key3", "value3");

        BoundHashOperations<String, Object, Object> boundHashOperations = stringRedisTemplate.boundHashOps("hash");
        boundHashOperations.delete("key1", "key2");
        boundHashOperations.put("key4", "value4");
    }
}

package com.coolk1ng;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.coolk1ng.redis.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * redis
 *
 * @author coolk1ng
 * @since 2023/6/6 13:09
 */
@SpringBootTest
public class RedisTest {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 追加字符串
     */
    @Test
    public void append() {
        redisTemplate.opsForValue().setIfAbsent("append_key", "append");
        redisTemplate.opsForValue().append("append_key", "_key");
    }

    @Test
    public void pushList() {
//        redisTemplate.opsForList().leftPush("list_key", "3");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        redisTemplate.opsForList().leftPushAll("list_key", list.toArray());
    }

    @Test
    public void zSet() {
        ZSetOperations.TypedTuple<Object> typedTuple1 = new DefaultTypedTuple<>("a", 1.1);
        ZSetOperations.TypedTuple<Object> typedTuple2 = new DefaultTypedTuple<>("b", 12.0);
        ZSetOperations.TypedTuple<Object> typedTuple3 = new DefaultTypedTuple<>("c", 22.1);
        Set<ZSetOperations.TypedTuple<Object>> set = new HashSet<>();
        set.add(typedTuple1);
        set.add(typedTuple2);
        set.add(typedTuple3);
        redisTemplate.opsForZSet().add("set_key", set);
    }


    //JUC工具类 栅栏，实现满一定数量线程后往下执行，跟countdownlatch不同的是，这个可以重复使用
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(100);


    @Test
    public void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<200;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int num = i%50;//这样是为了让一批线程里有两个相同的用户去竞争，主要是为了测试并发
            executorService.execute(()->{
                try {
                    play("userId"+num,"name"+num);
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void play(String userId,String name) throws BrokenBarrierException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 已准备");
        cyclicBarrier.await();

//        Map<String,String> map = new HashMap<>();
//        map.put("userId", userId);
//        map.put("name", name);
        User user = new User();
        user.setId(userId);
        HttpUtil.post("http://127.0.0.1:3333/seckill/placeOrder", JSON.toJSONString(user));
        System.out.println(Thread.currentThread().getName() + " 开始执行");
    }

    @Test
    public void redisProduct() {
        User user = new User();
        user.setId(String.valueOf(RandomUtil.randomInt(1, 100)));
        redisTemplate.convertAndSend("redis_message_channel", JSON.toJSON(user));
        log.info("发送消息成功!");
    }

    @Test
    public void redisProduct1() {
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId(String.valueOf(RandomUtil.randomInt(100, 200)));
            redisTemplate.convertAndSend("redis_message_channel", JSON.toJSON(user));
            log.info("发送消息成功!");
        }
    }
}

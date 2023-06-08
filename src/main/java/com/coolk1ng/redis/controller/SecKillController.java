package com.coolk1ng.redis.controller;

import cn.hutool.core.util.RandomUtil;
import com.coolk1ng.redis.entity.Stock;
import com.coolk1ng.redis.entity.User;
import com.coolk1ng.redis.mapper.StockMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

/**
 * 使用redis模拟秒杀
 *
 * @author coolk1ng
 * @since 2023/6/7 13:55
 */
@RestController
@RequestMapping("/seckill")
@Slf4j
public class SecKillController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private StockMapper stockMapper;

    @PostConstruct
    public void initData() {
        Stock fruit = stockMapper.getStock(Stock.builder().type("fruit").build());
        redisTemplate.opsForValue().set(fruit.getType(), String.valueOf(fruit.getCount()));
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody User user) {
        String userId = user.getId();
        String countByUser = redisTemplate.opsForValue().get(userId);
        if (countByUser != null && Integer.parseInt(countByUser) > 1){
            log.info("用户:{}抢过了, 当前数量:{}", userId, countByUser);
            return "只能每人买一个!!";
        }

        String countByStock = redisTemplate.opsForValue().get("fruit");
        if (countByStock != null && Integer.parseInt(countByStock) < 1) {
            log.info("剩余数量:{}", countByStock);
            return "卖完了!";
        }

        redisTemplate.execute(new SessionCallback<>() {
            @Override
            public String execute(RedisOperations redisOperations) throws DataAccessException {
                List<Objects> result = null;
                do {
                    redisOperations.watch("fruit");
                    int count = Integer.parseInt((String) redisOperations.opsForValue().get("fruit"));
                    int count1 = redisOperations.opsForValue().get(userId) == null ? 0 : Integer.parseInt((String)redisOperations.opsForValue().get(userId));
                    if (count1 > 0) {
                        log.info("用户:{}抢过了, 当前数量:{}", userId, count1);
                        break;
                    }

                    //开启事务
                    redisOperations.multi();
                    redisOperations.opsForValue().decrement("fruit", count - 1);
                    redisOperations.opsForValue().increment(userId, count1 + 1);
                    result = redisOperations.exec();

                    try {
                        Thread.sleep(RandomUtil.randomInt(1, 100));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (CollectionUtils.isEmpty(result));

                return result == null ? "" : result.toString();
            }
        });
        int count = Integer.parseInt(redisTemplate.opsForValue().get("fruit"));
        log.info("执行后商品数量:{}", count);
        return "";
    }
}

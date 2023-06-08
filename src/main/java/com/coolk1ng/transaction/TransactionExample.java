package com.coolk1ng.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试事务
 *
 * @author coolk1ng
 * @since 2023/3/23 21:53
 */
@Component
public class TransactionExample {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionExample1 transactionExample1;

    //手动事务
    @Transactional
    public void doTransactional() {
        TransactionConsumer transactionConsumer = () -> {
            userMapper.insert(User.builder().username("张三").age(10).build());
//            throw new RuntimeException();
        };
        int a = 1 / 0;
        transactionConsumer.doInTransactional();
    }

    //事务失效
//    @Transactional
    public void transactionFailTest1() {
        userMapper.insert(User.builder().username("张三").age(10).build());
        this.update(User.builder().username("张三").age(20).build());
    }

    @Transactional
    public void update(User user) {
        try {
            userMapper.update(user);
            int a = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //独立事务
//    @Transactional
    public void newTransactionEveryTime() {
        for (int i = 0; i < 10; i++) {
            User user = User.builder().username(String.valueOf(i)).age(i).build();
            try {
                transactionExample1.insertUser(user);
            } catch (Exception e) {

            }
        }
    }

    public void transaction() {
        User user = User.builder().username(String.valueOf(1)).age(1).build();
        try {
            transactionExample1.insertUser(user);
        } catch (Exception ignored) {
        }
    }
}

package com.coolk1ng.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author coolk1ng
 * @since 2023/4/28 01:32
 */
@Component
public class TransactionExample1 {

    @Autowired
    private UserMapper userMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUser(User user) {
        userMapper.insert(user);
        if (user.getAge() == 1) {
            throw new RuntimeException();
        }
    }
}

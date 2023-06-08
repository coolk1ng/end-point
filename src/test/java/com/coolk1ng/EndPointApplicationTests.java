package com.coolk1ng;

import com.coolk1ng.transaction.TransactionExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EndPointApplicationTests {
    @Autowired
    private TransactionExample transactionExample;

    @Test
    void contextLoads() {
        transactionExample.doTransactional();
    }

    @Test
    void test1() {
        transactionExample.transactionFailTest1();
    }

    @Test
    void test2() {
        transactionExample.newTransactionEveryTime();
    }

    @Test
    void test3() {
        transactionExample.transaction();
    }
}

package com.coolk1ng.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author coolk1ng
 * @since 2023/4/26 16:12
 */
@FunctionalInterface
public interface TransactionConsumer {
    @Transactional
    void doInTransactional();
}

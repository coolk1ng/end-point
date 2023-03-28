package com.coolk1ng.springboot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author coolk1ng
 * @since 2023/3/28 15:47
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService{

    @Override
    @Async
    public void generateReport() {
        log.info(Thread.currentThread().getName());
    }
}

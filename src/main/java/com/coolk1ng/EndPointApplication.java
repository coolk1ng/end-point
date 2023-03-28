package com.coolk1ng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EndPointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndPointApplication.class, args);
    }

}

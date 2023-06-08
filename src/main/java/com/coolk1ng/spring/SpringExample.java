package com.coolk1ng.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author coolk1ng
 * @since 2023/5/4 14:45
 */
@Component
public class SpringExample {
    public static String str;
    public @PostConstruct void init() {
        str = "str";
        System.out.println(str);
    }
}

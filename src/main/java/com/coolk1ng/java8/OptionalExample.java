package com.coolk1ng.java8;

import java.util.Optional;

/**
 * optional
 *
 * @author coolk1ng
 * @since 2023/4/12 10:39
 */
public class OptionalExample {


    public static void main(String[] args) {
        Job job = Job.builder().level("1").build();
        User user = User.builder().username("张三").job(job).build();
        String name1 = Optional
                .ofNullable(user)
                .map(User::getJob)
                .map(Job::getName)
                .orElse("default user");

        String name2 = Optional
                .ofNullable(user)
                .map(User::getJob)
                .map(Job::getName)
                .orElseThrow();
        System.out.println(name2);
    }
}

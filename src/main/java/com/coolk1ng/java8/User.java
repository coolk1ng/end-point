package com.coolk1ng.java8;

import lombok.Builder;
import lombok.Data;

/**
 * @author coolk1ng
 * @since 2023/4/12 10:39
 */
@Data
@Builder
public class User {
    private String username;
    private Job job;
}

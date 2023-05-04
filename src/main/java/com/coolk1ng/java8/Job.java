package com.coolk1ng.java8;

import lombok.Builder;
import lombok.Data;

/**
 * 职位
 *
 * @author coolk1ng
 * @since 2023/4/12 10:42
 */
@Data
@Builder
public class Job {
    private String level;
    private String name;
}

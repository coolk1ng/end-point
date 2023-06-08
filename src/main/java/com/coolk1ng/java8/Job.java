package com.coolk1ng.java8;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

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

    private String field1;
    private BigDecimal field2;
    private Double field3;
}

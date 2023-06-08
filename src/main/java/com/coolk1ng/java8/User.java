package com.coolk1ng.java8;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author coolk1ng
 * @since 2023/4/12 10:39
 */
@Data
@Builder
public class User {
    private String username;
    private Job job;
    private Integer field1;
    private Double field2;
    private BigDecimal field3;

}

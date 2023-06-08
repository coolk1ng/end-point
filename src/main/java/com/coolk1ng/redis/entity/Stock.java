package com.coolk1ng.redis.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author coolk1ng
 * @since 2023/6/7 13:59
 */
@Data
@Builder
public class Stock {
    private String id;
    private String type;
    private Integer count;
}

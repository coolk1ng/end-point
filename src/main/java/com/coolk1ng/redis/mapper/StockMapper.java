package com.coolk1ng.redis.mapper;

import com.coolk1ng.redis.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author coolk1ng
 * @since 2023/6/7 14:00
 */
@Mapper
public interface StockMapper {
    Stock getStock(Stock stock);
}

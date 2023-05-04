package com.coolk1ng.transaction;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author coolk1ng
 * @since 2023/4/26 16:17
 */
@Mapper
public interface UserMapper {

    void insert(User user);

    void update(User user);
}

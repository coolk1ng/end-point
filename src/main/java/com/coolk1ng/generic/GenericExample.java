package com.coolk1ng.generic;

import com.alibaba.fastjson.JSON;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coolk1ng
 * @since 2023/5/22 10:30
 */
@Log
public class GenericExample {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("1", "name1", 1));
        list.add(new User("2", "name2", 2));

        List<? extends User> list1 = new ArrayList<>();
        list1 = list;
        list1.forEach(item -> {
            item.setAge(10);
        });
        log.info(JSON.toJSONString(list1));
    }
}

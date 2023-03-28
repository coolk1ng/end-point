package com.coolk1ng.algorithm.example;

/**
 * 实现一个方法，来判断一个正整数是否是2的整数次幂（如16是2的4次方，返回 true；18不是2的整数次幂，则返回false）
 *
 * @author coolk1ng
 * @since 2023/3/20 14:09
 */
public class PowerOf2 {

    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(5));
    }
}

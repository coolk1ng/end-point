package com.coolk1ng.algorithm.example;

/**
 * 求最大公约数
 *
 * @author coolk1ng
 * @since 2023/3/20 13:31
 */
public class MaxCommonDivisor {

    public static void main(String[] args)
    {
        System.out.println(getMaxCommonDivisor(8, 4));
    }


    /**
     * 辗转相除法
     */
    public static int getMaxCommonDivisor(int a, int b)
    {
        int bigValue = Math.max(a, b);
        int smallValue = Math.min(a, b);

        if (bigValue % smallValue == 0)
        {
            return smallValue;
        }

        return getMaxCommonDivisor(a, b);
    }
}

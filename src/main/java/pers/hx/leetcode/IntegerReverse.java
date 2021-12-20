package pers.hx.leetcode;

import java.math.BigInteger;

/**
 * @program: wheels
 * @description: 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 LC-7
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * @create: 2021-12-13 17:37
 */

public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String xStr = String.valueOf(x);
        char[] xChar = xStr.toCharArray();
        int len = xChar.length;
        if (xChar[0] == '-') {
            for (int i = len - 1; i > (len - 1) / 2; i--) {
                char temp = xChar[i];
                xChar[i] = xChar[len - i];
                xChar[len - i] = temp;
            }
        } else {
            for (int i = len - 1; i >= len / 2; i--) {
                char temp = xChar[i];
                xChar[i] = xChar[len - i - 1];
                xChar[len - i - 1] = temp;
            }
        }
        long res = Long.valueOf(new String(xChar));
        if (res <= Integer.MIN_VALUE || res >= Integer.MAX_VALUE) {
            return 0;
        }
        return Integer.valueOf(new String(xChar));
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x >> 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}

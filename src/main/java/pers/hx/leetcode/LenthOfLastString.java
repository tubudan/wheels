package pers.hx.leetcode;

import java.util.Scanner;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-08-17 10:19
 */

public class LenthOfLastString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (null == input || input.length() >= 5000) {
            return;
        }
        String[] inputArr = input.split(" ");
        System.out.println(inputArr[inputArr.length-1].length());
    }
}

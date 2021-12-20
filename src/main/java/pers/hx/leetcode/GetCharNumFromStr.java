package pers.hx.leetcode;

import java.util.Scanner;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 * @create: 2021-08-17 10:33
 */

public class GetCharNumFromStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        int count = 0;
        if (null == inputStr || inputStr.length()>=500) return;
        String inputChar = in.next();
        if (inputChar.length() != 1) return;
        String inputStrUpper = inputStr.toUpperCase();
        char inputCharUpper = inputChar.toUpperCase().charAt(0);

        for (int i = 0; i <= inputStr.length() - 1; i++) {
            if (inputCharUpper == inputStrUpper.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

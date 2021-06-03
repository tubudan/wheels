package pers.hx.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-06-01 15:28
 */

public class LearnRegex {
    public static void main(String[] args) {
        //分组匹配
        Pattern pattern = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher matcher = pattern.matcher("0713-7062098");
//        pattern.matcher("0713 7062098");
//        pattern.matcher("0713*7062098");
        if (matcher.matches()) {
            String g = matcher.group(0);
            String g1 = matcher.group(1);
            String g2 = matcher.group(2);
            System.out.println(g);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败");
        }

        //非贪婪匹配符号：?,让当前子正则串尽量少匹配
        //区分\d? 和\d+?
        Pattern pattern1 = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher1 = pattern1.matcher("1230000");
        matcher1.find();
        if (matcher1.matches()) {
            System.out.println("group1=" + matcher1.group(1)); // "1230000"
            System.out.println("group2=" + matcher1.group(2)); // ""
        }

    }


    public static int[] parseTime(String s) {
        // FIXME:
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Pattern p = Pattern.compile("([0-1][0-9]|2[0-3])\\:([0-5][0-9])\\:([0-5][0-9])");
        Matcher m = p.matcher(s);
        if(m.matches()) {
            //返回一个int数组
            return new int[] {Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))};
        }else {
            throw new IllegalArgumentException();
        }
    }
}

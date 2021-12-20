package pers.hx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: wheels
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 LC-6-Middle
 * @create: 2021-12-10 15:13
 */

/*
input:PAYPALISHIRING ,3
output:PAHNAPLSIIGYIR
P   A   H   N
A P L S I I G
Y   I   R

input:PAYPALISHIRING ,4
output: PAHNAPLSIIGYIR
P     I    N
A   L S  I G
Y A   H R
P     I
*/
public class ZTransform {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        // 一个z周期是 numRows+numRows-2
        if (s.length()<=1 || numRows ==1) return s;
        StringBuilder result = new StringBuilder();
        int m = s.length();
        int n = numRows;
        char[][] temp = new char[m][n];
        char[] sArr = s.toCharArray();
        int p = 1;
        int x = -1;
        int y = 0;
        int cir = numRows + numRows - 2;
        while (p <= m) {
            x++;
            if (p % cir < numRows && p % cir != 0) {
                //自上而下
                //x+1,y++
                y = 0;
                for (int j = 0; j < n && p <= m; j++) {
                    temp[x][y] = sArr[p-1];
                    y++;
                    p++;
                }
                y--;
            } else {
                //排单个，x++,y--
                y--;
                temp[x][y] = sArr[p-1];
                p++;
            }

        }
        for (int b = 0; b < n; b++) {
            for (int c = 0; c < temp.length; c++) {
                if (temp[c][b] != 0) {
                    result.append(temp[c][b]);
                }
            }
        }
        return result.toString();
    }

    public String convert2(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}

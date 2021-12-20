package pers.hx.leetcode;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @create: 2021-12-02 16:42
 */

public class LengthOfLongestSubstring {
    public static String str = " asdsdvasdfasd";
//    public static String str = "asdd";

    public static int lengthOfLongestSubstringMy(String s) {
        if (s.length() == 1) return s.length();
        int length = 0;
        int max = length;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                System.out.println("子串："+s.substring(i, j));
                System.out.println("当前字符："+s.substring(j , j+1));
                if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    length = j - i;
                    break;
                }
                length = j - i + 1;

            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int max = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            // 将当前字符转换为int型
            int index = s.charAt(i);
            //ABCDSABCDEF
            start = Math.max(start, last[index] + 1);
            max   = Math.max(max, i - start + 1);
            last[index] = i;

            // 65 last[65]+1 = 0 start = 0 ; max = 0-0+1 =1 ;last[65] = 0
            // 66 last[66]+1 = 0 start = 0 ; max = 1-0+1 =2 ;last[66] = 1
            // 67 last[67]+1 = 0 start = 0 ; max = 2-0+1 =3 ;last[67] = 2
            // 68 last[68]+1 = 0 start = 0 ; max = 3-0+1 =4 ;last[68] = 3
            // 83 last[83]+1 = 0 start = 0 ; max = 4-0+1 =5 ;last[68] = 4
            // 65 last[65]+1 = 1 start = 1 ; max = 5-1+1 =5 ;last[65] = 5
            // 66 last[66]+1 = 1 start = 2 ; max = 6-2+1 =5 ;last[66] = 6
        }

        return max;
    }


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstringMy(str));
        System.out.println(lengthOfLongestSubstring(str));
    }
}

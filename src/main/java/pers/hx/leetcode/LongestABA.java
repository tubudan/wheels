package pers.hx.leetcode;

/**
 * @program: wheels
 * @description: 给你一个字符串 s，找到 s 中最长的回文子串。 LC-5
 * 输入：s = "babad"   (s 仅由数字和英文字母（大写和/或小写）组成 , 1 < s.length <= 1000)
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * @create: 2021-12-08 14:26
 */
/*
ababaca
abaabbaba
aba
abab
a
ac
asd
*/

public class LongestABA {
    public final static String s = "ccc";

    public static void main(String[] args) {
        System.out.println(longestPalindrome(s));
//        System.out.println(longestPalindromeODD(s));
    }

    //蛮牛法
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String s1 = longestPalindromeODD(s);
        String s2 = longestPalindromeEVEN(s);
        String maxStr = s1.length() >= s2.length() ? s1 : s2;
        return maxStr;
    }

    public static String longestPalindromeODD(String sODD) {
        char[] chars1 = sODD.toCharArray();
        int len = chars1.length;
        int max = 1;
        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            int p = 1;
            int j = i;
            int k = i;
            while (i - p >= 0 && i + p < len && chars1[j] == chars1[k]) {
                j = i - p;
                k = i + p;
                if (j >= 0 && k < len && max < (2 * p + 1) && chars1[j] == chars1[k]) {
                    l = j;
                    r = k;
                    max = r - l + 1;
                }
                p++;
            }

        }
        return sODD.substring(l, r + 1);
    }

    public static String longestPalindromeEVEN(String sEVEN) {
        char[] chars1 = sEVEN.toCharArray();
        int len = chars1.length;
        int max = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            int p = 0;
            int j = i;
            int k = i + 1;
            while (k < len && i - p >= 0 && i + p < len && chars1[j] == chars1[k]) {
                j = i - p;
                k = i + 1 + p;
                if (j >= 0 && k < len && max < (k - j + 1) && chars1[j] == chars1[k]) {
                    l = j;
                    r = k;
                    max = r - l + 1;
                }
                p++;
            }
        }
        return sEVEN.substring(l, r + 1);
    }

    //动态规划
    public static String longestPalindromeDYNAMIC(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}

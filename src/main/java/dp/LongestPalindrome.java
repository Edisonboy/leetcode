package dp;

/**
 * @author : zzh
 * create at:  2020/9/15
 * @description:No.5 最长回文串
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 *
 */
public class LongestPalindrome {


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        char[] charArrays = s.toCharArray();

        int maxLen = 0;
        int begin = 0;

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (charArrays[i] != charArrays[j]) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "ac";
        LongestPalindrome demo = new LongestPalindrome();
        System.out.println(demo.longestPalindrome(s));
    }
}

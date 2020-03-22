package str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zzh
 * create at:  2020/3/19
 * @description:
 */
public class CheckInclusion {
    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : s1.toCharArray())
            c1[c - 'a']++;

        for (int i = 0; i < len2; i++) {

            if (i > len1) {
                //先把坐标查过的
                --c2[s2.charAt(i - len1)-'a'];
            }
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s1 = "adc";
//        String s2 = "dcda";

        String s1 = "ab";
        String s2 = "eidbaooo";

//        String s1 = "ab";
//        String s2 = "eidboaoo";

//        String s1 = "hello";
//        String s2 = "ooolleoooleh";
        CheckInclusion demo = new CheckInclusion();
        System.out.println(demo.checkInclusion2(s1, s2));
    }
}

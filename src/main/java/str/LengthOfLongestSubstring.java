package str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zzh
 * create at:  2020/3/18
 * @description:no.3
 *
 * 最长不重复子串
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * 双指针i,j  j-i+1就是当前窗口的长度
     * map保存窗口指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        System.out.println(demo.lengthOfLongestSubstring(s));




    }
}

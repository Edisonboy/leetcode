package str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zzh
 * create at:  2020/3/18
 * @description:
 */
public class LengthOfLongestSubstring {

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

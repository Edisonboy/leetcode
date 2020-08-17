package str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/8/14
 * @description:no.763
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 *
 */
public class PartitionLabels {

    /**
     *
     * 1.
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        int size = chars.length;





        int maxPos = 0;
        for (int i = 0; i < size; i++) {
            int pos = S.lastIndexOf(chars[i]);
            if (pos == i) {
                list.add(1);
            }else {
                maxPos = Math.max(maxPos, pos);
                for (int j = i + 1; j < maxPos; j++) {
                    maxPos = Math.max(maxPos, S.lastIndexOf(chars[j]));
                }
                list.add(maxPos - i + 1);
                i = maxPos;
            }
        }
        return list;
    }


    public List<Integer> partitionLabels2(String S) {
        List<Integer> list = new ArrayList<>();

        // 记录每个字符最大的下标
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++) {
            map[S.charAt(i)-'a'] = i;
        }

        int last = 0;
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(new PartitionLabels().partitionLabels2(S));
    }

}

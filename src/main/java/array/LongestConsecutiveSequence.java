package array;

import java.util.*;

/**
 * @author : zzh
 * create at:  2020/4/20
 * @description:
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int maxVal = 1;
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        for (int i = 1; i < list.size(); i++) {
            Integer preVal = map.get(list.get(i) - 1);
            if (preVal != null) {
                map.put(list.get(i), ++preVal);
                maxVal = Math.max(maxVal, preVal);
            }
        }
        return maxVal;
    }


    public int longestConsecutive2(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0,0};
        LongestConsecutiveSequence demo = new LongestConsecutiveSequence();
        System.out.println(demo.longestConsecutive(nums));
    }
}

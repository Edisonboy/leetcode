package dp;

import java.util.Random;

/**
 * @author : zzh
 * create at:  2020/8/5
 * @description:no.300
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */


public class LengthOfLIS {


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            if ()
//            dp[i] = Math.max()
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = 10;
        while (--i > 0) {
            System.out.println(new Random().nextInt(3));
        }

    }

}

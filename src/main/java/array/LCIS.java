package array;

import java.util.Arrays;

/**
 * @author : zzh
 * create at:  2020/4/19
 * @description:
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 *
 */
public class LCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int i = 0, max = 1;
        while (i < nums.length) {
            int val = 1;
            int j = i;
            while (j < nums.length-1 && nums[j] < nums[j+1]) {
                val++;
                j++;
            }
            max = Math.max(max, val);
            i += val;
        }
        return max;
    }

    /*public int findLengthOfLCIS(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i])
                res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;
    }*/

    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        // dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
//        int[] nums = {2,2,2,2,2};
        LCIS lcis = new LCIS();
        System.out.println(lcis.findLengthOfLCIS2(nums));
    }
}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/4/10
 * @description:
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        // 排序
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果当前值>0不再存在小于0的数
            if(nums[i] > 0)
                return results;

            // 去掉重复的
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            // 左右指针
            int left = i + 1, right = nums.length - 1, sum = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] > sum) {
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    right--;
                }else if (nums[left] + nums[right] < sum) {
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    left++;
                }else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return results;
    }


    public static void main(String[] args) {
        // [-4, -1, -1, 0, 1, 2]
        int[] array = {-1, 0, 1, 2, -1, -4};
//        int[] array = {0,0,0,0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> results = threeSum.threeSum(array);
        System.out.println(Arrays.toString(results.toArray()));
    }
}

package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/3/27
 * @description:
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>());

        return result;
    }

    public void helper(int[] nums, List<List<Integer>> results, List<Integer> list) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i : nums) {
            if (list.contains(i))
                continue;
            list.add(i);
            helper(nums, results, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations permutations = new Permutations();
        permutations.permute(nums);
    }
}

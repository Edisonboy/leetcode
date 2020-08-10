package dp;

import java.util.List;

/**
 * @author : zzh
 * create at:  2020/8/4
 * @description:no.120 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();

        int[][] dp = new int[n][n];

        List<Integer> list = triangle.get(n - 1);

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = list.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + row.get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        //初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // 状态转移方程
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Integer.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

    }
}

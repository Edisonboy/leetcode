package dp;

/**
 * @author : zzh
 * create at:  2020/8/3
 * @description:122
 */
public class MaxProfit2 {


    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                max += temp;
            }
        }
        return max;
    }
}

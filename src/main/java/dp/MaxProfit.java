package dp;

/**
 * @author : zzh
 * create at:  2020/8/2
 * @description:no.121
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(a));
    }
}

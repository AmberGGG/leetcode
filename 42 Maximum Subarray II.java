public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //DP
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min;
        int n = prices.length;
        int[] profit = new int[n + 1];
        profit[0] = 0;
        profit[1] = 0;
        min = prices[0];
        for (int i = 2; i <= n; i++){
            profit[i] = Math.max(profit[i - 1], prices[i - 1] - min);
            if (prices[i - 1] < min){
                min = prices[i - 1];
            }
        }
        return profit[n];
    }
}
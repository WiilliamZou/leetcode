public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int lowPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - lowPrice);
            lowPrice = Math.min(lowPrice, price);
        }
        return maxProfit;
    }
}
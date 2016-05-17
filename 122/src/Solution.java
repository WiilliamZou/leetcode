public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length;) {
            if (i < prices.length-1 && prices[i] < prices[i+1]) {
                int j = i+1;
                while (j < prices.length-1 && prices[j] < prices[j+1]) {
                    j++;
                }
                profit += prices[j] - prices[i];
                i = j+1;
            } else {
                i++;
            }
        }
        return profit;
    }
}
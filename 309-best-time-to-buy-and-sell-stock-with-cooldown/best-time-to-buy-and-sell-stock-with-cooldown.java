class Solution {
  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length + 2][3];
    
    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 1) {
          dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
        } else {
          dp[i][buy] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        }
      }
    }
    return dp[0][1];
  }
}
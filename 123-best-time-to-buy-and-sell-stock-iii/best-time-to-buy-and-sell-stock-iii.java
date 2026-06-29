class Solution {
  public int maxProfit(int[] prices) {
    int[][][] dp = new int[prices.length+1][2][3];

    for (int i = prices.length - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        for (int cap = 1; cap <= 2; cap++) {
          if (buy == 1) {
            dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap],
                dp[i + 1][1][cap]);
          } else {
            dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1],
                dp[i + 1][0][cap]);
          }

        }
      }
    }
    return dp[0][1][2];
  }
}
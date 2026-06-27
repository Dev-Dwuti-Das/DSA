class Solution {
  public int maxProfit(int[] prices) {
    int[][][] dp = new int[prices.length][2][3];
    for (int i = 0; i < prices.length; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -(int) 1e9);
      }
    }
    return helper(0, 1, 2, prices, dp);
  }

  public int helper(int i, int buy, int cap, int[] prices, int[][][] dp) {

    if (i == prices.length)
      return 0;
    if (cap == 0)
      return 0;

    if (dp[i][buy][cap] != -(int) 1e9) return dp[i][buy][cap];
      
    int profit = 0;

    if (buy == 1) {
      dp[i][buy][cap] = Math.max(-prices[i] + helper(i + 1, 0, cap, prices, dp), helper(i + 1, 1, cap, prices, dp));
    } else {
      dp[i][buy][cap] = Math.max(prices[i] + helper(i + 1, 1, cap - 1, prices, dp), helper(i + 1, 0, cap, prices, dp));
    }

    return dp[i][buy][cap];
  }
}
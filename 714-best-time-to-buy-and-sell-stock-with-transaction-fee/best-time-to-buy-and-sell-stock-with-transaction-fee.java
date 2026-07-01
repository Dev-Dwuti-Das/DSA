class Solution {
  public int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length+1][3];
    for(int i = 0; i < prices.length; i++){
      Arrays.fill(dp[i], -1);
    }
    return helper(0, 1, prices, fee, dp);
  }

  public int helper(int i, int buy, int[] prices, int fee, int[][] dp) {

    if (i == prices.length) {
      return 0;
    }

    if(dp[i][buy] != -1) return dp[i][buy];

    int profit = 0;
    if (buy == 1) {
      dp[i][buy] = Math.max(-prices[i] + helper(i + 1, 0, prices, fee, dp), helper(i + 1, 1, prices, fee, dp));
    } else {
      dp[i][buy] = Math.max(prices[i] + helper(i + 1, 1, prices, fee, dp) - fee, helper(i + 1, 0, prices, fee, dp));
    }
    return dp[i][buy];
  }
}
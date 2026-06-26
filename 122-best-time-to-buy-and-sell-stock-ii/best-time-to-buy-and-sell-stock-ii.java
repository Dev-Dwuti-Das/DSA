class Solution {
  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][3];
    for(int i = 0; i < prices.length; i++){
      Arrays.fill(dp[i], -1);
    }
    return helper(0, 1, prices, dp);
  }

  public int helper(int i, int buy, int[] prices, int[][] dp) {

    if (i == prices.length)
      return 0;

    int profit = 0;

    if(dp[i][buy] != -1) return dp[i][buy];

    if (buy == 1) {
      dp[i][buy] = Math.max(-prices[i] + helper(i + 1, 0, prices, dp), helper(i + 1, 1, prices, dp));
    } else {
      dp[i][buy] = Math.max(prices[i] + helper(i + 1, 1, prices, dp), helper(i + 1, 0, prices, dp));
    }

    return dp[i][buy];
  }
}
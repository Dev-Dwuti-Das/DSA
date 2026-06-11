class Solution {
  public int coinChange(int[] coins, int amount) {

    int dp[][] = new int[coins.length][amount+1];
    for (int i = 0; i < coins.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    int res = helper(coins.length - 1, amount, coins, dp);

    return (res == (int) 1e9) ? -1 : res;
  }

  public int helper(int i, int temp, int[] arr, int[][] dp) {
    if (i == 0) {
      if (temp % arr[0] == 0) {
        return temp / arr[0];
      }
      return (int) 1e9;
    }

    if(dp[i][temp] != -1) return dp[i][temp];

    int take = Integer.MAX_VALUE;
    if (arr[i] <= temp) {
      take = 1 + helper(i, temp - arr[i], arr, dp);
    }
    int notake = helper(i - 1, temp, arr, dp);

    return dp[i][temp] = Math.min(take, notake);
  }
}
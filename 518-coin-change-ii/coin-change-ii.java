class Solution {
    public int change(int amount, int[] coins) {
      int[][] dp = new int[coins.length][amount + 1];
      for(int i = 0; i < coins.length; i++){
        Arrays.fill(dp[i], -1);
      }
      return helper(coins.length-1, amount, coins, dp);
    }

    public int helper(int i, int temp, int[] coins, int[][] dp){

      if(i == 0){
        if(temp % coins[i] == 0) return 1;
        return 0;
      }

      if(dp[i][temp] != -1) return dp[i][temp];

      int take = 0;
      if(coins[i] <= temp){
        take = helper( i, temp - coins[i], coins, dp);
      }
  
      int nottake =  helper( i-1, temp, coins,dp);

      return dp[i][temp] = nottake + take;
    }
}
class Solution {
    public int climbStairs(int n) {
      int count = 0;
      int[] dp = new int[n+1];
      Arrays.fill(dp, -1);
      return f(n, count, dp);
    }

    public int f(int n, int c, int[] dp){
      if(n == 0) return c + 1;
      if(n < 0) return 0;
      if(dp[n] != -1) return dp[n];
      int step1 = f(n-1, c, dp);
      int step2 = f(n-2, c, dp); 
      return dp[n] = step1+step2; 
    }
}
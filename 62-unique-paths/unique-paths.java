class Solution {
  public int uniquePaths(int m, int n) {
    int count = 0;
    int[][] dp = new int[m][n];
    // for(int i = 0; i < m; i++){
    //   Arrays.fill(dp[i], -1);
    // }

    dp[m - 1][n - 1] = 1;
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int right = 0;
        int down = 0;
        if(i == m-1 && j == n-1) continue;
        if(j + 1 < n) right = dp[i][j + 1];
        if(i + 1 < m) down = dp[i+1][j];
        dp[i][j] = right + down;
      }
    }
    return dp[0][0];
  }

}
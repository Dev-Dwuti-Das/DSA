class Solution {
  public int cherryPickup(int[][] grid) {
    int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++){
        Arrays.fill(dp[i][j], -1);
      }
    }
    return helper(0, 0, grid[0].length - 1, grid, dp);
  }

  public int helper(int r, int c1, int c2, int[][] grid, int[][][] dp) {
    if (r >= grid.length || c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length)
      return Integer.MIN_VALUE;

    if (r == grid.length - 1) {
      if (c1 == c2) {
        return grid[r][c1];
      } else {
        return grid[r][c1] + grid[r][c2];
      }
    }
    if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
    int maxi = Integer.MIN_VALUE;

    int[] dir_c = { -1, 0, +1 };

    for (int k = 0; k < 3; k++) {
      for (int p = 0; p < 3; p++) {
        maxi = Math.max(maxi, helper(r + 1, c1 + dir_c[k], c2 + dir_c[p], grid, dp));
      }
    }

    int curr = 0;
    if (c1 == c2) {
      curr = grid[r][c1];
    } else {
      curr = grid[r][c1] + grid[r][c2];
    }
    return dp[r][c1][c2] = maxi + curr;
  }
}
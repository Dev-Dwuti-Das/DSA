class Solution {
  public int uniquePathsWithObstacles(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return helper(0, 0, grid.length, grid[0].length, dp, grid);
  }

  public int helper(int row, int col, int m, int n, int[][] dp, int[][] grid) {
    if (row == m - 1 && col == n - 1 && grid[row][col] == 0)
      return 1;
    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 1)
      return 0;

    if (dp[row][col] != -1)
      return dp[row][col];

    int right = helper(row, col + 1, m, n, dp, grid);
    int down = helper(row + 1, col, m, n, dp, grid);

    int sum = right + down;
    return dp[row][col] = sum;
  }
}

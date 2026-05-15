class Solution {
    public int minPathSum(int[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      int[][] dp = new int[row][col];
      for(int i = 0; i < row; i++){
        Arrays.fill(dp[i], -1);
      }
      return helper(0, 0, dp, grid);
    }

    public int helper(int i, int j, int[][] dp, int[][] grid){
      if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
      if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 ) return Integer.MAX_VALUE;
      if(dp[i][j] != -1) return dp[i][j];

      int right = helper(i, j+1, dp, grid);
      int down = helper(i+1, j, dp, grid);

      dp[i][j] = grid[i][j] + Math.min(right, down);
      return dp[i][j];
    }
}
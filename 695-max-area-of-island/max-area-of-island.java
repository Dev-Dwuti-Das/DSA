class Solution {
  int max = Integer.MIN_VALUE;
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] isvisited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !isvisited[i][j]) {
          int currarea = dfs(i, j, isvisited, grid);
          System.out.println(currarea);
          max = Math.max(currarea, max);
        }
      }
    }
    return (max == Integer.MIN_VALUE) ? 0 : max;
  }

  public int dfs(int row, int col, boolean[][] isvisited, int[][] grid){

    if(row < 0 || col < 0 || row >= isvisited.length || col >= isvisited[0].length || isvisited[row][col] || grid[row][col] == 0){
      return 0;
    }

    isvisited[row][col] = true;
    int d = dfs(row + 1, col, isvisited, grid);
    int u = dfs(row - 1, col, isvisited, grid);
    int r = dfs(row, col + 1, isvisited, grid);
    int l = dfs(row, col - 1, isvisited, grid);
    return 1 + d + u + r + l;
  }

}
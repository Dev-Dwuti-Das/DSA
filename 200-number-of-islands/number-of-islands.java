class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    boolean[][] isvisited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && !isvisited[i][j]) {
          count++;
          dfs(i, j, isvisited, grid);
        }
      }
    }
    return count;
  }

  public void dfs(int row, int col, boolean[][] isvisited, char[][] grid) {
    if (row < 0 || col < 0 || row >= isvisited.length || col >= isvisited[0].length || grid[row][col] == '0' || isvisited[row][col])  {
      return;
    }
    isvisited[row][col] = true;
    dfs(row + 1, col, isvisited, grid);
    dfs(row - 1, col, isvisited, grid);
    dfs(row, col + 1, isvisited, grid);
    dfs(row, col - 1, isvisited, grid);
  }
}
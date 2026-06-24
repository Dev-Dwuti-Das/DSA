class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public void solve(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      if (grid[i][0] == 'O') {
        dfs(i, 0, grid, visited);
      }
      if (grid[i][grid[0].length - 1] == 'O') {
        dfs(i, grid[0].length - 1, grid, visited);
      }
    }
    for (int j = 0; j < grid[0].length; j++) {
      if (grid[0][j] == 'O') {
        dfs(0, j, grid, visited);
      }
      if (grid[grid.length - 1][j] == 'O') {
        dfs(grid.length - 1, j, grid, visited);
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j]) {
          grid[i][j] = 'X';
        }
      }
    }
  }

  public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
    if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 'X')
      return;
    visited[i][j] = true;
    
    for (int[] d : dir) {
      int nr = i + d[0];
      int nc = j + d[1];
      dfs(nr, nc, grid, visited);
    }
  }
}
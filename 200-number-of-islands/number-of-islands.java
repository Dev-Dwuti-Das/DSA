class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public int numIslands(char[][] grid) {
      int count = 0;
      int[][] visited = new int[grid.length][grid[0].length];
      for(int i = 0 ; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(visited[i][j] == 0 && grid[i][j] == '1'){
            dfs(i, j, grid, visited);
            count++;
          }
        }
      }
      return count;
    }

    public void dfs(int i, int j, char[][] image, int[][] visited){
      if (i >= image.length || j >= image[0].length || i < 0 || j < 0 || image[i][j] == '0' || visited[i][j] == 1) return;

      visited[i][j] = 1;

      for (int[] d : dir) {
      int nr = i + d[0];
      int nc = j + d[1];
      dfs(nr, nc, image, visited);
    }    
  }
}
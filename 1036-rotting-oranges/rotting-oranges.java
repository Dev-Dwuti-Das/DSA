class Solution {
  public int orangesRotting(int[][] grid) {
    int time = 0;
    int fresh = 0;
    int n = grid.length;
    int m = grid[0].length;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isvisited = new boolean[n][m];
    int[] rowdir = { -1, +1, 0, 0 };
    int[] coldir = { 0, 0, -1, +1 };
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          q.offer(new int[]{i,j});  
          isvisited[i][j] = true;
        }
        else if(grid[i][j] == 1){
          fresh++; 
        }
      }
    }
    if(fresh == 0) return 0;

    while (!q.isEmpty()) {
      boolean isrotted = false;
      int size = q.size();
      for(int k = 0; k < size; k++){
        int[] item = q.poll();
        int x = item[0];
        int y = item[1];
        for (int i = 0; i < 4; i++) {
          int nrow = x + rowdir[i];
          int ncol = y + coldir[i];
          if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !isvisited[nrow][ncol] && grid[nrow][ncol] == 1) {
            q.offer(new int[] { nrow, ncol });
            grid[nrow][ncol] = 2;
            isrotted = true;
            fresh--;
            isvisited[nrow][ncol] = true;
          }
        }
      }
    if(isrotted) time++;
    }
    if(fresh > 0) return -1;
  return time;
  }
}
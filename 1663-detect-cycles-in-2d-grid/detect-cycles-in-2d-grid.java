class Solution {
  public boolean containsCycle(char[][] grid) {
    Set<Character> set = new HashSet<>();
    boolean[][] isvisited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!isvisited[i][j]) {
          char curr = grid[i][j];
          if (bfs(i, j, grid, curr, isvisited)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  //CYCLE KA RULE : 1) SAME CHAR HONA CHAIYE 2) PARENT NHI HONA CHAHIYE 3) VISITED HONA CHAHIYE

  public boolean bfs(int row, int col, char[][] grid, char curr, boolean[][] isvisited) {
    int[] rd = { -1, +1, 0, 0 };
    int[] cd = { 0, 0, -1, +1 };
    int n = grid.length;
    int m = grid[0].length;
    isvisited[row][col] = true;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { row, col, -1, -1 });
    while (!q.isEmpty()) {
      int[] item = q.poll();
      int x = item[0];
      int y = item[1];
      int px = item[2];
      int py = item[3];
      for (int i = 0; i < 4; i++) {
        int nr = x + rd[i];
        int nc = y + cd[i];
        if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] != curr) {
          continue;
        }
        if (isvisited[nr][nc]) {
          if (nr != px || nc != py) {
            return true;
          }
        } else {
          q.add(new int[] { nr, nc, x, y});
          isvisited[nr][nc] = true;

        }
      }
    }
    return false;
  }
}
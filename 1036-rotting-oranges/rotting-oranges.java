class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int orangesRotting(int[][] grid) {
    int time = 0;
    int fresh = 0;
    int rotted = 0;
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        }
        if (grid[i][j] == 2) {
          rotted++;
          q.offer(new int[] { i, j });
        }
      }
    }
    if (fresh + rotted == 0)
      return 0;
    while (!q.isEmpty()) {
      boolean cur_rotted = false;

      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] item = q.poll();
        int x = item[0];
        int y = item[1];
        if (grid[x][y] == 1) {
          cur_rotted = true;
          fresh--;
        }
        grid[x][y] = 2;

        for (int[] nei : dir) {
          int nr = x + nei[0];
          int nc = y + nei[1];
          if (nr < grid.length && nc < grid[0].length && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
            q.offer(new int[] { nr, nc });
          }
        }
      }
      if (cur_rotted)
        time++;
    }
    if (fresh != 0)
      return -1;
    return time;
  }
}

//&& image[nr][nc] != color
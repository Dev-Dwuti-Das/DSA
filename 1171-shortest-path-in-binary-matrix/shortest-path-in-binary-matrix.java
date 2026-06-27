class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int[][] visited = new int[grid.length][grid[0].length];
    Queue<int[]> q = new LinkedList<>();
    if (grid[0][0] == 1)
      return -1;

    q.offer(new int[] { 0, 0, 1 });

    while (!q.isEmpty()) {

      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] item = q.poll();
        int x = item[0];
        int y = item[1];
        int dist = item[2];

        if (x == grid.length - 1 && y == grid[0].length - 1) {
          return dist;
        }

        for (int[] d : dir) {
          int nr = x + d[0];
          int nc = y + d[1];

          if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0
              && visited[nr][nc] == 0) {
            visited[nr][nc] = 1;
            q.offer(new int[] { nr, nc, dist + 1 });
          }
        }
      }
    }

    return -1;

  }
}
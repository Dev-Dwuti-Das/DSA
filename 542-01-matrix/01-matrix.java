class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[][] updateMatrix(int[][] mat) {
    int[][] res = new int[mat.length][mat[0].length];
    int[][] visited = new int[mat.length][mat[0].length];
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[] { i, j, 0 });
          visited[i][j] = 1;
        }
      }
    }

    while (!q.isEmpty()) {

      int size = q.size();
      for (int i = 0; i < size; i++) {

        int[] item = q.poll();
        int x = item[0];
        int y = item[1];
        int dist = item[2];
        
        res[x][y] = dist;

        for (int[] nei : dir) {
          int nr = x + nei[0];
          int nc = y + nei[1];

          if (nr < mat.length && nc < mat[0].length && nr >= 0 && nc >= 0 && visited[nr][nc] == 0) {
            visited[nr][nc] = 1;
            q.offer(new int[] { nr, nc, dist + 1 });
          }
        }
      }
    }
    return res;
  }
}
class Solution {
  public int[][] updateMatrix(int[][] mat) {

    int m = mat.length;
    int n = mat[0].length;

    Queue<int[]> q = new LinkedList<>();

    // step 1: push all 0s
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[]{i, j});
        } else {
          mat[i][j] = -1; // mark unvisited 1
        }
      }
    }

    int[][] dir = {
        {1,0},{-1,0},{0,1},{0,-1}
    };

    // step 2: BFS
    while (!q.isEmpty()) {

      int[] item = q.poll();
      int x = item[0];
      int y = item[1];

      for (int[] moves : dir) {

        int nx = x + moves[0];
        int ny = y + moves[1];

        if (nx >= 0 && ny >= 0 && nx < m && ny < n && mat[nx][ny] == -1) {

          mat[nx][ny] = mat[x][y] + 1;
          q.offer(new int[]{nx, ny});
        }
      }
    }

    return mat;
  }
}

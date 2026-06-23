class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    dfs(sr, sc, color, image, visited, image[sr][sc]);
    return image;
  }

  public void dfs(int i, int j, int color, int[][] image, boolean[][] visited, int precol) {
    if (i >= image.length || j >= image[0].length
        || i < 0 || j < 0 ||
         visited[i][j] || image[i][j] != precol)
      return;
    
    int prevcol = image[i][j];
    visited[i][j] = true;
    image[i][j] = color;

    for (int[] d : dir) {
      int nr = i + d[0];
      int nc = j + d[1];
      dfs(nr, nc, color, image, visited, prevcol);
    }
  }
}

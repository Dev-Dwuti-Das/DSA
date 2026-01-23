class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int m = image.length;
    int n = image[0].length;
    int currcolor = image[sr][sc];
    boolean[][] isvalid = new boolean[m][n];
    if (image[sr][sc] != color) {
      dfs(sr, sc, image, color, currcolor );
    }
    return image;
  }

  public void dfs(int row, int col, int[][] image, int color, int cc) {
    if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) {
      return;
    }
    if( cc == color || image[row][col] != cc){
      return;

    }

    image[row][col] = color;
    dfs(row + 1, col, image, color, cc);
    dfs(row - 1, col, image, color, cc);
    dfs(row, col + 1, image, color, cc);
    dfs(row, col - 1, image, color, cc);
  }
}
class Solution {
  int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{sr,sc});

    while(!q.isEmpty()){
      int[] item = q.poll();
      int x = item[0];
      int y = item[1];

      int prev_col = image[x][y];
      image[x][y] = color;

      for(int[] nei : dir){
        int nr = x + nei[0];
        int nc = y + nei[1];
        if (nr < image.length && nc < image[0].length && nr >= 0 && nc >= 0 && image[nr][nc] == prev_col && image[nr][nc] != color){
          q.offer(new int[]{nr, nc});
        }
      }      
    }
  return image;
  }

  
}
//|| image[i][j] == color)
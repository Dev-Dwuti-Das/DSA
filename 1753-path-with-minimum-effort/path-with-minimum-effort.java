class Solution {
  int[][] dir = {{1,0},{-1, 0},{0 ,1},{0, -1}};
    public int minimumEffortPath(int[][] heights) {
      int[][] dist = new int[heights.length][heights[0].length];
      Queue<int[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2]);    
      q.offer(new int[]{0,0,0});   
      for(int i = 0; i < heights.length; i++){
        Arrays.fill(dist[i], (int)1e9);
      }
      dist[0][0] = 0;

      while(!q.isEmpty()){
        int[] item = q.poll();
        int x = item[0];
        int y = item[1];
        int diff = item[2];

        if(x == heights.length-1 && y == heights[0].length-1) return dist[x][y];

        for(int[] d : dir){
          int nr = x + d[0];
          int nc = y + d[1];

          if(nr < heights.length && nc < heights[0].length && nr >= 0 && nc >= 0){
            int max = Math.max(diff, Math.abs(heights[nr][nc] - heights[x][y]));
            if(dist[nr][nc] > max){
              dist[nr][nc] = max;
              q.offer(new int[]{nr, nc, dist[nr][nc]});
            }
          }
        }
      }
    return 0;
    }
}
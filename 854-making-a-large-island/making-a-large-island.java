class Solution {
  int[] parents;
  int[] size;
  int max = Integer.MIN_VALUE;
  int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
  public int largestIsland(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;  //galti
    int n = row * col;
    parents = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      parents[i] = i;
      size[i] = 1; //galti
    }

    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        int node1 = (i * col) + j;
        if(grid[i][j] == 1){
          for(int[] d: dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(isvalid(nr, nc, row, col) && grid[nr][nc] == 1){ //galti
              int node2 = nr*col + nc; 
              union(find(node1), find(node2));
            }
          }
        } 
      }
    }

    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        int node3 = (i * col) + j;
        Set <Integer> set = new HashSet<>();
        if(grid[i][j] == 0){
          for(int[] d: dir){
            int nr = i + d[0];
            int nc = j + d[1];
            int node4 = nr*col + nc;
            if( isvalid(nr, nc, row, col) && grid[nr][nc] == 1){
              set.add(find(node4));
            }
          }
          int curr_size = 1;  //galti
          for(int val : set){
              curr_size += size[val];
          }
          max = Math.max(curr_size, max);
        }
      }
    } 
  return max == Integer.MIN_VALUE ? n : max;
  }

  public int find(int u) {
    if (parents[u] == u)return u;
    parents[u] = find(parents[u]);
    return parents[u];
  }

  public boolean isvalid(int r, int c, int row, int col){
    return (r >= 0 && r < row && c >= 0 && c < col);
  }

  public void union(int u, int v) {
    if (u == v) return;
    if(size[u] > size[v]){
      parents[v] = u;
      size[u] += size[v];
    }else{
      parents[u] = v;
      size[v] += size[u];
    }
  }
}
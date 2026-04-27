class Solution {
    int[] parents;
    public int findCircleNum(int[][] mat) {
      int len = mat.length;
      int res = 0;
      parents = new int[len+1];
      Set<Integer> set = new HashSet<>();
      for(int i = 0; i < len; i++){
        parents[i] = i;
      }

      for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
          if(mat[i][j] == 1 && i != j){
            int p_i = find(i);
            int p_j = find(j);
            if(p_i != p_j) Union(p_i, p_j); 
          }
        }
      }

      for(int i = 0; i < len; i++){
        set.add(find(i));
      } 
      return set.size();   
    }

    public int find(int node){
        if(parents[node] == node) return node;
        parents[node] = find(parents[node]);
        return parents[node];
    }
    
    public void Union(int u, int v){
        parents[v] = u;
    }
}
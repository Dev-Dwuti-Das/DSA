class Solution {
  int[] parents;
  int[] size;
  int count = 0;
  public int removeStones(int[][] stones) {
    int n = stones.length;
    parents = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      parents[i] = i;
      size[i] = 1; //galti
    }

    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
          union(find(i), find(j));
        }
      }
    }
    Map<Integer , Integer> map = new HashMap<>(); 
    for(int i = 0; i < n; i++){
       map.put(find(i), map.getOrDefault(find(i), 0)+1);
    }

    for(int val : map.values()){
      count += val-1;
    }

  return count;
  }

  public int find(int u) {
    if (parents[u] == u) return u;
    parents[u] = find(parents[u]);
    return parents[u];
  }

  public void union(int u, int v) {
    if (u == v)
      return; //galti
    if (size[u] > size[v]) {
      parents[v] = u;
      size[u] += size[v];
    } else {
      parents[u] = v;
      size[v] += size[u];
    }
  }
}


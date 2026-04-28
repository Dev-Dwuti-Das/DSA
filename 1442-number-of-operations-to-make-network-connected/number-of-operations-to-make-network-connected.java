class Solution {
    int[] parents;
    public int makeConnected(int n, int[][] connections) {
    parents = new int[n+1];
    int extra = 0;
    int connected = 0;
    int len = connections.length;
    for(int i = 0; i < n; i++){
      parents[i] = i;
    }

    for(int[] edges : connections){
      int u = edges[0];
      int v = edges[1];
      int P_u = find(u);
      int P_v = find(v);
      if(P_u == P_v){
        extra++;
      }else{
        connected++;
        union(P_u,P_v);
      }
      
    } 
    System.out.println(extra);
    System.out.println(connected); 
    if(extra + connected < n - 1) return -1;
    return n - connected - 1;      
    }

    public int find(int u){
      if(parents[u] == u) return u;
      parents[u] = find(parents[u]);
      return parents[u];
    }

    public void union(int u, int v){
      parents[v] = u;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;
      int count = 0;
      boolean[] isvalid = new boolean[n];
      for(int i = 0; i < n; i++){
        if(!isvalid[i]){
          count++;
          bfs(i, isConnected, isvalid);
        }
      }
      return count;        
    }

    public void bfs(int node, int[][] isConnected, boolean[] isvalid){
      Queue<Integer> q = new LinkedList<>();
      q.offer(node);
      isvalid[node] = true;
      while(!q.isEmpty()){
        int item = q.poll();
        for(int j = 0; j < isConnected.length; j++){
           if(isConnected[node][j] == 1 && !isvalid[j]){
            q.offer(j);
            isvalid[j] = true; 
            bfs(j, isConnected, isvalid);
           }
        }
      }
    }
}
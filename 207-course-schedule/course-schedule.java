class Solution {
    public boolean canFinish(int V, int[][] box) {
     int[] inedges = new int[V];
      List<List<Integer>> adj = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      for(int i = 0; i < V; i++){
        adj.add(new ArrayList<>());
      }
      for(int[] e : box){
        adj.get(e[0]).add(e[1]);
      }
      for(int i = 0; i < V; i++){
        for(int x : adj.get(i)){
          inedges[x]++;
        }
      }

      for(int i = 0; i < V; i++){
        if(inedges[i] == 0){
          q.offer(i);
        }
      }

      int count = 0;
      while(!q.isEmpty()){
        int item = q.poll();
        count++;

        for(int nei : adj.get(item)){
          inedges[nei]--;
          if(inedges[nei] == 0) q.offer(nei);
        }
      }

    return count == V;

    }
}
class Solution {
    public int[] findOrder(int V, int[][] box) {
      int[] inedges = new int[V];
      int[] res = new int[V];
      List<List<Integer>> adj = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      for(int i = 0; i < V; i++){
        adj.add(new ArrayList<>());
      }
      for(int[] e : box){
        adj.get(e[1]).add(e[0]);
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
        temp.add(item);
        count++;

        for(int nei : adj.get(item)){
          inedges[nei]--;
          if(inedges[nei] == 0) q.offer(nei);
        }
      }

      for(int i = 0; i < temp.size(); i++){
        res[i] = temp.get(i);
      }

    return count == V ? res : new int[]{};
    }
}
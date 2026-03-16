class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : flights) {
            adj.get(e[0]).add(new int[] { e[1], e[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 , 0});  //node, stops, cost
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int parent_node = item[0];
            int stops = item[1];
            int parent_dist = item[2];

            if(stops > k) continue;
            
            for (int[] nei : adj.get(parent_node)) {
                int nei_node = nei[0];
                int nei_dist = nei[1];

                if (dist[nei_node] > parent_dist + nei_dist) {
                    dist[nei_node] = parent_dist + nei_dist;
                    pq.offer(new int[] { nei_node, stops+1 , parent_dist + nei_dist});
                }
            }
        }
        return dist[dst] == (int)1e9 ? -1 : dist[dst];
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = (int)1e9 + 7;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : roads) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] item = pq.poll();
            long cost = item[0];
            int node = (int) item[1];   // ✅ FIX

            //bc kya long aur int ka choddddd h 

            //main logic dekhlio firse ek bar

            for(int[] nei : adj.get(node)){   // ✅ FIX
                int next = nei[0];
                int weight = nei[1];

                long newDist = cost + weight;


                //yeah h main logic yeah dekhlio ma chudae long aur int 
                if(newDist < dist[next]){
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{newDist, next});  // ✅ FIX
                }
                else if(newDist == dist[next]){
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}
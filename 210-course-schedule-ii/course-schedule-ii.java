class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        int V = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        int[] res = new int[V];

        for (int k = 0; k < V; k++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        int[] inorder = new int[V];
        for (int i = 0; i < V; i++) {
            for (int x : adj.get(i)) {
                inorder[x]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inorder[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        int i = V-1;
        while (!q.isEmpty()) {
            int item = q.poll();
            count++;
            res[i] = item;
            i--;
            for (int x : adj.get(item)) {
                inorder[x]--;
                if (inorder[x] == 0) {
                    q.offer(x);
                }
            }

        }
        if(count != V) return new int[0]; 
     return res; 
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        int V = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

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
        while (!q.isEmpty()) {
            int item = q.poll();
            count++;

            for (int x : adj.get(item)) {
                inorder[x]--;
                if (inorder[x] == 0) {
                    q.offer(x);
                }
            }

        }
     return count == V;
    }
}
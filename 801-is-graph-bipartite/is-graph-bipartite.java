class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] color = new int[graph.length];

        for (int k = 0; k < graph.length; k++) {
            if (!visited[k]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(k);
                visited[k] = true;
                color[k] = 1;
                while (!q.isEmpty()) {
                    int item = q.poll();
                    for (Integer i : graph[item]) {
                        if (!visited[i]) {
                            color[i] = 1 - color[item];
                            visited[i] = true;
                            q.offer(i);
                        } else if (color[i] == color[item]) {
                            return false;

                        }
                    }
                }
            }
        }
        return true;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                color[i] = 1;
                while (!q.isEmpty()) {
                    int item = q.poll();
                    for (int x : graph[item]) {
                        if (!visited[x]) {
                            color[x] = 1 - color[item];
                            visited[x] = true;
                            q.offer(x);
                        } else {
                            if (color[item] == color[x]) {
                                return false;
                            }
                        }
                    }
                }

            }
        }

        return true;
    }
}
import java.util.*;

class Solution {

    boolean[] visited;
    boolean[] path;
    boolean[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int V = graph.length;

        visited = new boolean[V];
        path = new boolean[V];
        safe = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }

        for (int j = 0; j < V; j++) {
            if (safe[j]) {
                res.add(j);
            }
        }
        return res;
    }

    public boolean dfs(int node, int[][] graph) {

        visited[node] = true;
        path[node] = true;

        for (int x : graph[node]) {
            if (!visited[x]) {
                if (dfs(x, graph)) return true;
            } else if (path[x]) {
                return true;
            }
        }

        safe[node] = true;
        path[node] = false;
        return false;
    }
}
class Solution {
  public int findCircleNum(int[][] graph) {
    int count = 0;
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      adj.add(new ArrayList<>());
    }
    boolean[] visited = new boolean[graph.length];

    //adj matrix to adj list
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        if (i != j && graph[i][j] == 1) {
          adj.get(i).add(j);
        }
      }
    }

    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        count++;
        dfs(i, graph, visited, adj);
      }
    }

    return count;

  }

  public void dfs(int i, int[][] graph, boolean[] visited, List<List<Integer>> adj) {

    visited[i] = true;
    for (int child : adj.get(i)) {
      if (!visited[child]) {
        dfs(child, graph, visited, adj);
      }

    }

  }
}
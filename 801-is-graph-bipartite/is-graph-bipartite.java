class Solution {
  public boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < graph.length; i++) { // this to handle edge case alone standing node with connections;

      if (color[i] != -1) continue;
      q.offer(new int[] { i, 0 });
      color[i] = 0;

      while (!q.isEmpty()) {
        int[] item = q.poll();
        int node = item[0];

        for (int nei : graph[node]) {
          if (color[nei] == -1) {
            color[nei] = 1 - color[node];
            q.offer(new int[] { nei, 1 - color[node] });
          } else if (color[nei] == color[node]) {
            return false;
          }
        }
      }

    }

    return true;
  }
}
class Solution {
  int[] parents;

  public int[] findRedundantConnection(int[][] edges) {
    parents = new int[edges.length+1];

    for (int i = 0; i < edges.length; i++) {
      parents[i] = i;
    }

    for (int[] item : edges) {
      int u = item[0];
      int v = item[1];

      int P_u = find(u);
      int P_v = find(v);

      if (P_u == P_v) {
        return new int[] { u, v };
      } else {
        union(P_u, P_v);
      }
    }

    return new int[] { -1, -2 };
  }

  public int find(int u) {
    if (parents[u] == u) return u;
    parents[u] = find(parents[u]);
    return parents[u];
  }

  public void union(int u, int v) {
    parents[v] = u;
  }
}
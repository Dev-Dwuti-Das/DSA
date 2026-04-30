class Solution {

    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        parent[pb] = pa;
        size[pa] += size[pb];
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // your logic: union if same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        // count component sizes
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        // sum(size - 1)
        int ans = 0;
        for (int val : map.values()) {
            ans += (val - 1);
        }

        return ans;
    }
}
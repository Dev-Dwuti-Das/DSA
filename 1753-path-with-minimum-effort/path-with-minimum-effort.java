class Solution {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        dist[0][0] = 0;
        q.offer(new int[] { 0, 0, 0 });
        int[][] dir = {
                { -1, 0 },
                { 1, 0 },
                { 0, 1 },
                { 0, -1 },
        };

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int x = item[1];
            int y = item[2];
            int diff = item[0];

            if (x == n - 1 && y == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nei_diff = Math.abs(grid[nx][ny] - grid[x][y]);         
                    int max_diff = Math.max(diff, nei_diff);
                    
                    if (dist[nx][ny] > max_diff) {
                        dist[nx][ny] = max_diff;
                        q.offer(new int[] { max_diff, nx, ny });
                    }
                }
            }
        }
        return 0;
    }
}
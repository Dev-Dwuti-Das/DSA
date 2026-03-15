class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1) return -1;
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(dist[i], (int)1e9);
        }
        dist[0][0] = 0;
        q.offer(new int[] { 0, 0, 0 });
        int[][] dir = {
                { -1, 0 },
                { 1, 0 },
                { 0, 1 },
                { 0, -1 },
                { 1, 1 },
                { -1, -1 },
                { -1, 1 },
                { 1, -1 }
        };

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int x = item[0];
            int y = item[1];
            int cost = item[2];

            if (x == n-1 && y == m-1) {
                return dist[x][y] + 1;
            }

            for(int i = 0; i < 8; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0){
                    System.out.println("row :" + nx + "col :" + ny);
                    if(dist[nx][ny] > cost + 1){
                        dist[nx][ny] = cost + 1;
                        q.offer(new int[]{nx,ny,cost + 1});
                    }
                }
            }

        }
    
    return -1;
    }
}
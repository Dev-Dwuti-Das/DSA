class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int[][] dir = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        while (!q.isEmpty()) {
            boolean flag = false;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] item = q.poll();
                int x = item[0];
                int y = item[1];
                for (int[] moves : dir) {
                    int nx = x + moves[0];
                    int ny = y + moves[1];

                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        flag = true;
                        q.offer(new int[] { nx, ny });

                    }
                }

            }
            if(flag){
                time++;
            }

        }
        if (fresh != 0)
            return -1;

        return time;
    }

}
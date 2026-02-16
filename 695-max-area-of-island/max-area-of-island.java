class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(countdfs(grid, i, j, visited), max);
                }
            }
        }

        return max;
    }

    public int countdfs(int[][] grid, int i, int j, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int up = countdfs(grid, i + 1, j, visited);
        int left = countdfs(grid, i, j + 1, visited);
        int down = countdfs(grid, i - 1, j, visited);
        int right = countdfs(grid, i, j - 1, visited);

        return up + down + left + right + 1;
    }
}
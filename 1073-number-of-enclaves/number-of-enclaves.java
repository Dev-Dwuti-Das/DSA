class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid);
            dfs(i, grid[0].length - 1, grid);
        }

        for (int j = 0; j < grid[0].length; j++) {
            dfs(0, j, grid);
            dfs(grid.length - 1, j, grid);
        }

        for (int k = 0; k < grid.length; k++) {
            for (int p = 0; p < grid[0].length; p++) {
                if (grid[k][p] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] grid) {

        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0 || grid[i][j] == -1) {
            return;
        }
        grid[i][j] = -1;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}
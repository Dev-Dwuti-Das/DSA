class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        int curcol = image[sr][sc];
        image[sr][sc] = color;
        System.out.print(image[sr][sc]);

        int[][] dir = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int r = item[0];
            int c = item[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < n && nc < m && nc >= 0 && nr >= 0 && !visited[nr][nc] && image[nr][nc] == curcol) {
                    q.offer(new int[] { nr, nc});
                    visited[nr][nc] = true;
                    image[nr][nc] = color;
                }
            }

        }
        return image;
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
      int height = tri.size();
      int[][] dp = new int[height][height];
      for(int i = 0; i < height; i++){
        Arrays.fill(dp[i],(int)1e9);
      }
      return helper(0, 0, tri, height, dp); 
    }


    public int helper(int row, int j, List<List<Integer>> tri, int h, int[][] dp){
      if(row == h-1) return tri.get(row).get(j);

      if(row >= tri.size() || j >= tri.get(row).size()) return Integer.MAX_VALUE;

      if(dp[row][j] != (int)1e9) return dp[row][j];

      int down = helper(row + 1, j, tri, h, dp);
      int down_right = helper(row + 1, j + 1, tri, h, dp);

      return dp[row][j] = tri.get(row).get(j) + Math.min(down, down_right);
    }
}
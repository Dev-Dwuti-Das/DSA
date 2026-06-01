class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int res = Integer.MAX_VALUE;

    int[][] dp = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], (int)1e9);
    }

    for (int k = 0; k < matrix[0].length; k++) {
      res = Math.min(res, helper(matrix, dp, 0, k));
    }

    return res;
  }

  public int helper(int[][] mat, int[][] dp, int i, int j) {

    if (i >= mat.length || j >= mat[0].length || j < 0)
      return Integer.MAX_VALUE;

    if (i == mat.length - 1)
      return mat[i][j];

    if(dp[i][j] != (int)1e9) return dp[i][j];

    int down = helper(mat, dp, i + 1, j);
    int down_left = helper(mat, dp, i + 1, j - 1);
    int down_right = helper(mat, dp, i + 1, j + 1);

    return dp[i][j] = mat[i][j] + Math.min(down, Math.min(down_left, down_right));
  }
}
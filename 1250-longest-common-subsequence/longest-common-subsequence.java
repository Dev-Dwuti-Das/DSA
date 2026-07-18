class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int n1 = text1.length();
    int n2 = text2.length();
    int[][] dp = new int[n1][n2];
    for(int i = 0; i < n1; i++){
      Arrays.fill(dp[i], -1);
    }
    return helper(n1 - 1, n2 - 1, text1, text2, dp);
  }

  public int helper(int i, int j, String st1, String st2, int[][] dp) {
    if (i < 0 || j < 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    int match = 0;
    if (st1.charAt(i) == st2.charAt(j)) {
      match = 1 + helper(i - 1, j - 1, st1, st2, dp);
    }
    int notmatch = Math.max(helper(i - 1, j, st1, st2, dp), helper(i, j - 1, st1, st2, dp));
    return dp[i][j] = Math.max(match, notmatch);
  }

}
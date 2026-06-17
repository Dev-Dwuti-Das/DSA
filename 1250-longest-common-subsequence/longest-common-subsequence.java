class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for(int i = 0; i < text1.length(); i++){
      Arrays.fill(dp[i], -1);
    }
    return helper(text1.length() - 1, text2.length() - 1, text1, text2, dp);
  }

  public int helper(int i, int j, String s1, String s2, int[][] dp) {

    if (i < 0 || j < 0) {
      return 0;
    }

    if(dp[i][j] != -1) return dp[i][j];

    int equal = 0;
    if (s1.charAt(i) == s2.charAt(j)) {
      equal = 1 + helper(i - 1, j - 1, s1, s2, dp);
    }
    int notequal = 0 + Math.max(helper(i - 1, j, s1, s2, dp), helper(i, j - 1, s1, s2, dp));

    return dp[i][j] = Math.max(equal, notequal);
  }
}
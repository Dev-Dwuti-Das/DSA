class Solution {
  public int minDistance(String word1, String word2) {
    return word1.length() + word2.length() - 2*(longestCommonSubsequence(word1, word2));
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        int equal = 0;
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          equal = 1 + dp[i - 1][j - 1];
        }
        int notequal = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
        dp[i][j] = Math.max(equal, notequal);
      }
    }
    return dp[text1.length()][text2.length()];
  }

}
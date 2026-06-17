class Solution {
  public int findLength(int[] s1, int[] s2) {
    int[][] dp = new int[s1.length + 1][s2.length + 1];
    StringBuilder sb = new StringBuilder();
    int maxi = Integer.MIN_VALUE;

    for (int i = 1; i <= s1.length; i++) {
      for (int j = 1; j <= s2.length; j++) {
        int equal = 0;
        if (s1[i - 1] == s2[j - 1]) {
          equal = 1 + dp[i - 1][j - 1];
          maxi = Math.max(equal, maxi);
        }
        int notequal = 0;
        dp[i][j] = Math.max(equal, notequal);
      }
    }

    return (maxi == Integer.MIN_VALUE) ? 0 : maxi;
  }
}
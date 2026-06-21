class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {
    return findLCS(str1.length() - 1, str2.length() - 1, str1, str2);
  }

  public String findLCS(int n, int m, String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        int equal = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          equal = 1 + dp[i - 1][j - 1];
        }
        int notequal = Math.max(dp[i - 1][j], dp[i][j - 1]);
        dp[i][j] = Math.max(equal, notequal);
      }
    }
    int i = s1.length();
    int j = s2.length();

    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        sb.append(s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] >= dp[i][j - 1]) {
        sb.append(s1.charAt(i - 1));
        i--;
      } else {
        sb.append(s2.charAt(j - 1));
        j--;
      }
    }

    System.out.print(j);

    while (i > 0) {
      sb.append(s1.charAt(i - 1));
      i--;
    }

    while (j > 0) {
      sb.append(s2.charAt(j - 1));
      j--;
    }

    return sb.reverse().toString();
  }
}
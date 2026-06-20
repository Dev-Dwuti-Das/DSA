class Solution {
    public int longestPalindromeSubseq(String s) {
      StringBuilder sb = new StringBuilder(s);
      int[][] dp = new int[s.length()+1][s.length()+1];
      String s2 = sb.reverse().toString();
      
      for(int i = 1; i <= s.length(); i++){
        for(int j = 1; j <= s2.length(); j++){
          int equal = 0;
          if(s.charAt(i-1) == s2.charAt(j-1)){
            equal = 1 + dp[i-1][j-1];
          }
          int not = Math.max(dp[i-1][j],dp[i][j-1]);
          dp[i][j] = Math.max(not, equal);
        }
      }
      return dp[s.length()][s2.length()];
    }  
}
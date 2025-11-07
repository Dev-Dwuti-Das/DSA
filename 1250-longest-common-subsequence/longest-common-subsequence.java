class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m]; 

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return solve(n-1, m-1, text1, text2, dp);
    }

    public int solve(int i, int j, String s1, String s2, int[][] dp){


        if(i < 0 || j < 0) return 0;


        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(
            solve(i-1, j, s1, s2, dp),
            solve(i, j-1, s1, s2, dp)
        );
    }
}

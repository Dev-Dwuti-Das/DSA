class Solution {
    Double[][] dp = new Double[101][101];
    public double champagneTower(int poured, int row, int col) {
        return Math.min(1.0, helper(row, col, poured));
    }

    public double helper(int row, int col, int poured){
        if(row == 0 && col == 0){
            return poured;
        }
        if(row < 0 || col < 0 || col > row){
            return 0;
        }
        if(dp[row][col] != null){
            return dp[row][col];
        }
        double left = (helper(row-1, col-1, poured)-1)/2;
        if(left < 0) left = 0;
        double right = (helper(row-1, col, poured)-1)/2;
        if(right < 0) right = 0;
        return dp[row][col] = left+right;
    }
}
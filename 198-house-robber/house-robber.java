class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      int[] dp = new int[nums.length];
      Arrays.fill(dp ,-1);
      dp[0] = nums[0];

      for(int i = 0; i < nums.length; i++){
        int take = nums[i] + ((i-2 >= 0) ? dp[i - 2] : 0);
        int nottake = 0 + ((i-1 >= 0) ? dp[i - 1] : 0);
        dp[i] = Math.max(take, nottake);
      }
      return dp[nums.length-1];
    }
}
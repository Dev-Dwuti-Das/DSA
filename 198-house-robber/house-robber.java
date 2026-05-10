class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      int[] dp = new int[nums.length];
      Arrays.fill(dp ,-1);
      return helper(nums.length-1, nums, dp, n);
    }

    public int helper(int i, int[] nums, int[] dp, int n){
      if(i < 0) return 0;
      if(i == 0) return nums[0];
      if(dp[i] != -1) return dp[i];
      int take = nums[i] + helper(i - 2, nums, dp, n);
      int nottake = 0 + helper(i - 1, nums, dp, n);
      return dp[i] = Math.max(take, nottake);
    }
}
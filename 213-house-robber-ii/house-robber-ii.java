class Solution {
    public int rob(int[] nums) {
      if(nums.length == 1) return nums[0];

      int n = nums.length;
      int[] dp1 = new int[n];
      int[] dp2 = new int[n];
      Arrays.fill(dp1, -1);
      Arrays.fill(dp2, -1);
      return Math.max(helper(n-1, 1, nums, dp1), helper(n-2, 0, nums, dp2));
    }


    public int helper(int i, int end, int[] nums, int[] dp){
      if(i == end) return nums[i];
      if(i < end) return 0;

      if(dp[i] != -1) return dp[i];

      int take = nums[i] + helper(i - 2, end, nums, dp);
      int not_take = 0 + helper(i - 1, end, nums, dp); 

      return dp[i] = Math.max(take, not_take);
    }
}
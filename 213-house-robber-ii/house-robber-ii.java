class Solution {
    public int rob(int[] nums) {
      if(nums.length <= 1) return nums[0];
      int n = nums.length;
      int[] dp1 = new int[n];
      Arrays.fill(dp1, -1);
      int[] dp2 = new int[n];
      Arrays.fill(dp2, -1);
      return Math.max(helper1(1, nums, n-1, dp1), helper1(0, nums, n-2, dp2));
    }

    public int helper1(int i, int[] nums, int end, int[] dp1){  
      if(i == end) return nums[i];
      if(i > end) return 0;
      if(dp1[i] != -1) return dp1[i];
      int path1 = nums[i] + helper1(i+2, nums, end, dp1);
      int path2 = 0 + helper1(i+1, nums, end, dp1);
      return dp1[i] = Math.max(path1, path2);
    }

    
}
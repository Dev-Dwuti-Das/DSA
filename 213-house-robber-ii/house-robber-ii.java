class Solution {
    public int rob(int[] nums) {
      if(nums.length <= 1) return nums[0];
      int n = nums.length;
      int[] dp1 = new int[n];
      int[] dp2 = new int[n];
      Arrays.fill(dp1, -1);
      Arrays.fill(dp2, -1);
      return Math.max(helper1(nums.length-2, nums, n, dp1), helper2(1, nums, n, dp2));
    }

    public int helper1(int i, int[] nums, int n, int[] dp1){  //peche se samne
      if(i == 0) return nums[i];
      if(i < 1) return 0;
      if(dp1[i] != -1) return dp1[i];
      int path1 = nums[i] + helper1(i-2, nums, n, dp1);
      int path2 = 0 + helper1(i-1, nums, n, dp1);
      return dp1[i] = Math.max(path1, path2);
    }

    public int helper2(int i, int[] nums, int n, int[] dp2){   //samne se peche
      if(i == n-1) return nums[n-1];
      if(i > n-1) return 0;
      if(dp2[i] != -1) return dp2[i];
      int path1 = nums[i] + helper2(i+2, nums, n, dp2);
      int path2 = 0 + helper2(i+1, nums, n, dp2);
      return dp2[i] = Math.max(path1, path2);
    }
}
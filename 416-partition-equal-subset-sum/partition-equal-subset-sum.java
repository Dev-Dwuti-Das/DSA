class Solution {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if (sum % 2 != 0)
      return false;
    int temp = sum / 2;
    Boolean[][] dp = new Boolean[nums.length + 1][temp + 1];
    return helper(0, temp, nums, dp);
  }

  public Boolean helper(int i, int temp, int[] nums, Boolean[][] dp) {
    if (i == nums.length)
      return false;
    if (temp == 0)
      return true;

    if (dp[i][temp] != null)
      return dp[i][temp];
    Boolean taken = false;
    if (nums[i] <= temp) {
      taken = helper(i + 1, temp - nums[i], nums, dp);
    }
    Boolean not = helper(i + 1, temp, nums, dp);

    return dp[i][temp] = not || taken;
  }
}
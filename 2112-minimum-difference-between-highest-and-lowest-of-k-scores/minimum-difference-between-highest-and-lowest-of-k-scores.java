class Solution {
    public int minimumDifference(int[] nums, int k) {
      int mini = Integer.MAX_VALUE;
      Arrays.sort(nums);
      for(int i = nums.length - 1; i >= k - 1; i--){
        mini = Math.min(mini, nums[i] - nums[ i - k + 1]);
      }
    return mini;
    }
}
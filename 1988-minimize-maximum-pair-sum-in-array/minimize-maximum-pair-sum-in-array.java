class Solution {
    public int minPairSum(int[] nums) {
      Arrays.sort(nums);
      int max = Integer.MIN_VALUE;
      int r = nums.length-1;
      int l = 0;
      while(l < r){
        int temp = nums[l] + nums[r];
        max = Math.max(temp, max);
        l++;
        r--;
      }
      return max;
    }
}
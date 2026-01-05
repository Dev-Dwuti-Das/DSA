class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      // int sum = 0;
      // int min_val = Integer.MAX_VALUE;
      // for(int k = 0; k < nums.length; k++){
      //   sum += nums[k];
      //   min_val = Math.min(min_val, nums[k]);
      // }
      // if(sum < target) return 0;

      int min = Integer.MAX_VALUE;
      int l = 0;
      int cursum = 0;
      for( int r = 0; r < nums.length; r++){
        cursum += nums[r];
        while(cursum >= target){
          min = Math.min(min, r - l + 1);
          cursum -= nums[l];
          l++;
        }
      }
    return min == Integer.MAX_VALUE ? 0 : min;
    }
}
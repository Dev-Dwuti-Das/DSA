class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int l = 0;
      int r = 0;
      int sum = 0;
      int res = Integer.MAX_VALUE;

      while( r < nums.length){
        sum += nums[r];
        while(sum >= target){
          res = Math.min(r - l + 1, res);
          sum -= nums[l];
          l++;
        }  
        r++;
      }
      return res == Integer.MAX_VALUE ? 0 : res;
    }
}
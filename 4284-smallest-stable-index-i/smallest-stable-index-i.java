class Solution {
    public int firstStableIndex(int[] nums, int k) {
      int left_max = nums[0];
      int right_min = Integer.MAX_VALUE;

      for(int i = 0; i < nums.length; i++){
        if(left_max - findmin_right(nums, i) <= k){
          return i;
        }
        left_max = Math.max(nums[i], left_max);
      }
      return -1;
    }


    public int findmin_right(int[] arry, int p){
      int min = Integer.MAX_VALUE;
      for(int i = arry.length-1; i >= 0; i--){
        min = Math.min(min, arry[i]);
        if(i == p) break;
      }
      return min;
    }
}
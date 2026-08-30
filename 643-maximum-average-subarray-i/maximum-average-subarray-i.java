class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int l = 0;
      int r = 0;
      double max = Integer.MIN_VALUE;
      int sum = 0;
      while(r < nums.length){
        while(r - l < k){
          sum += nums[r];
          r++;
        }
        max = Math.max(max ,(double)(sum)/k);
        sum -= nums[l];
        l++;
      }
      return max;
    }
}
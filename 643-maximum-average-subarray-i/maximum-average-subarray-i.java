class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int winsum = 0;
      double max = Integer.MIN_VALUE;
      while(right < nums.length){
        while(right - left < k - 1){
          winsum += nums[right];
          right++;
        }
        winsum += nums[right];
        max = Math.max(max, (double)winsum/k);
        winsum -= nums[left];
        right++;
        left++;
      }
     return max;
    }
}
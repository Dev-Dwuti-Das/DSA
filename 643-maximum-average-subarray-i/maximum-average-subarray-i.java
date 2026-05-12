class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int left = 0;
      int right = 0;
      double max = Integer.MIN_VALUE;
      while(right < nums.length){
        while(right - left < k - 1){
          right++;
        }
        max = Math.max(max, avg(left, right, nums));
        right++;
        left++;
      }
     return max;
    }

    public double avg(int left, int right, int[] nums){
      int sum = 0;
      for(int i = left ; i <= right; i++){
        sum += nums[i];
      }
      return (double)sum/(right-left+1);
    }
}
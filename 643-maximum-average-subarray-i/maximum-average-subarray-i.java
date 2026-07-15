class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int left = 0;
    int right = 0;
    int sum = 0;
    double max = Integer.MIN_VALUE;

    while (right < nums.length) {
      while (right - left + 1 <= k) {
        sum += nums[right];
        right++;
      }
      max = Math.max(max, (double)sum / k);
      sum -= nums[left];
      left++;
    }
    return max;
  }
}
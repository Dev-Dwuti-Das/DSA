class Solution {
  public int longestOnes(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int temp_k = k;
      int max = Integer.MIN_VALUE;

      while(right < nums.length){
        if(nums[right] == 0){
          temp_k--;
        }
        
        while(temp_k < 0){
          if(nums[left] == 0){
            temp_k++;
          }
          left++;
        }
      
        if(temp_k >= 0){
          max = Math.max(max, right - left + 1);
        }
        right++;
      }
      return (max == Integer.MIN_VALUE) ? k : max;
    }
}
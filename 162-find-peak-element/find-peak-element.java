class Solution {
    public int findPeakElement(int[] nums) {
      int left = 0;
      int right = nums.length-1;
      if(nums.length == 1) return 0;
      while(left <= right){
        int mid = (left+right)/2;
        int right_edge = (mid+1 >= nums.length) ? Integer.MIN_VALUE : nums[mid+1];
        int left_edge = (mid-1 <= -1) ? Integer.MIN_VALUE : nums[mid-1];  
        if(nums[mid] > right_edge && left_edge < nums[mid]){
          return mid;
        }
        if(nums[mid] < nums[mid+1]){
          left = mid + 1;
        }else if(nums[mid] < nums[mid-1]){
          right = mid - 1;
        }
      }
      return left-1;
    }
}
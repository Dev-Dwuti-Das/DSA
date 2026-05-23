class Solution {
    public int[] searchRange(int[] nums, int target) {
      int right = binsearch_right(nums, target);
      int left = binsearch_left(nums, target);
      System.out.print(right);
      return new int[]{left,right};
    }

    public int binsearch_right(int[] nums, int target){
      int left = 0;
      int right = nums.length-1;
      int value = -1;

      while(left <= right){
        int mid = (left + right)/2;

        if(nums[mid] == target){
          value = mid;
          left = mid + 1;
        }
        else if(nums[mid] < target){
          left = mid + 1;
        }else{
          right = mid - 1;

        }
      }
      return value;
    }

    public int binsearch_left(int[] nums, int target){
      int left = 0;
      int right = nums.length-1;
      int value = -1;

      while(left <= right){
        int mid = (left + right)/2;

        if(nums[mid] == target){
          value = mid;
          right = mid - 1;
        }
        else if(nums[mid] < target){
          left = mid + 1;
        }else{
          right = mid - 1;

        }
      }
      return value;
    }
}
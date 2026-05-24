class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target)
        return mid;

      if (nums[left] <= nums[mid]) { // left sorted

        if (nums[left] <= target && target < nums[mid]) { // element here
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {// right sorted
        if (nums[mid] < target && target <= nums[right]) { //element here
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        if (nums.length == 1 && target == nums[0]) {
            return 0;
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[min] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[min]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[max]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;

                }
            }
        }
        return -1;
    }
}
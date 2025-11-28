class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while( l < r){
            int mid = (r+l)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }

            if(nums[r] < nums[mid]){
                l = mid + 1; 
            }else{
                r = mid;
            }
        }
    return nums[r];
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int r = nums.length-1;
        int l = 0;
        while (l < r){
            if(nums[l] + nums[r] == target){
                res[0] = l+1;
                res[1] = r+1;
            }

            if(nums[l] + nums[r] > target){
                r--;
            }else{
                l++;
            }
        }
    return res;
    }
}
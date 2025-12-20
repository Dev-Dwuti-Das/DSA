class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(Integer x : nums){
            sum += x;  
        }
        if(sum % k != 0) return false;
        boolean[] valid = new boolean[nums.length];
        return backtrack(nums, valid, 0, 0, sum/k, k);
        
    }


    public boolean backtrack(int[] nums, boolean[] valid, int i, int cursum, int target, int k){
        if(k == 1) return true;

        if(cursum == target){
           return backtrack(nums, valid, 0, 0, target, k-1);
        }

        for(int p = i; p < nums.length; p++){
            if(valid[p]) continue;
            if(cursum + nums[p] > target){
                continue;
            }
            valid[p] = true;
           if(backtrack(nums, valid, p+1, cursum+nums[p], target, k)) return true;
            valid[p] = false;
        }
    return false;
    }
}
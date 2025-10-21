class Solution {
    public int maxSubArray(int[] nums) {
        int final_sum = 0;
        int[] prefix_sum = new int[nums.length];
        if(nums[0] < 0){
            prefix_sum[0] = 0;
        }else{
            prefix_sum[0] = nums[0];
            final_sum = nums[0];
        }
        for(int i = 1; i < nums.length; i++){
            int sum = prefix_sum[i-1] + nums[i]; 
            if(sum < 0){
                prefix_sum[i] = 0;
            }
            else{
                prefix_sum[i] = sum;
            }
            final_sum = Math.max(sum, final_sum); 
        }
        if(final_sum == 0){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
    return final_sum;
    }
}
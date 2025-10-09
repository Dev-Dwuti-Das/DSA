class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int temp_sum = 0;
        for(Integer i : nums){
            temp_sum += i;
        }
        if(temp_sum < target) return 0;
        int l = 0;
        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                int len = r - l + 1;
                min_len = Math.min(min_len, len);
                sum -= nums[l];
                l++;
            }
        }
        return min_len;
    }
}
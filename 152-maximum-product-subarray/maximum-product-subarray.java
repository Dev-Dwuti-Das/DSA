class Solution {
    public int maxProduct(int[] nums) {
      int pre_max = Integer.MIN_VALUE;
      int suf_max = Integer.MIN_VALUE;
      int prefix = 1;
      int sufix = 1;
      int res = Integer.MIN_VALUE;

      for(int i = 0; i < nums.length; i++){
        prefix *= nums[i];
        sufix *= nums[nums.length - i - 1];

        pre_max = Math.max(pre_max, prefix);
        suf_max = Math.max(suf_max, sufix);
        
        if(nums[i] == 0) prefix = 1;
        if(nums[nums.length - i - 1] == 0) sufix = 1;
        
      }

      res = Math.max(pre_max, suf_max);
      return res;
    }
}
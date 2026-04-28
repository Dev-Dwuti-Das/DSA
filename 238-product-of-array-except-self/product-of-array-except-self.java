class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0];
    int[] res = new int[nums.length];
    int[] sufix = new int[nums.length];
    sufix[nums.length - 1] = nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i];
      sufix[nums.length - i - 1] = sufix[nums.length - i] * nums[nums.length - i - 1];
    }

    for (int i = 0; i < nums.length; i++) {
      if(i == 0){
        res[i] = sufix[i+1];
      }
      else if(i == nums.length-1){
        res[i] = prefix[i-1];
      }
      else{
        res[i] = prefix[i - 1] * sufix[i + 1];
      }
    }
   return res;
  }
}
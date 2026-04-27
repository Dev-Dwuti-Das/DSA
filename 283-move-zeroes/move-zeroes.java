class Solution {
    public void moveZeroes(int[] nums) {
      if(nums.length < 2) return;
      int temp[] = new int[nums.length];

      int li = 0;
      int ri = nums.length-1;
      int i = 0;

      while(i < nums.length && ri >= 0){
        System.out.print(nums[i]);
        if(nums[i] == 0){
          temp[ri] = 0;
          ri--;
          
        }else{
          temp[li] = nums[i];
          li++;
          
        }
        i++;
      }
    for(int j = 0; j < nums.length; j++){
      nums[j] = temp[j];
    }
  }
}
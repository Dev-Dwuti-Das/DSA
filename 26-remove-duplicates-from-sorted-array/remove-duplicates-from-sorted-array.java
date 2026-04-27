class Solution {
    public int removeDuplicates(int[] nums) {
      Set<Integer> set = new HashSet<>();
      int k = 0;
      int i = 0;
      int idx = 0;
      while(i < nums.length){
        if(set.add(nums[i])){
          nums[idx] = nums[i];
          idx++;
          k++;
        }
        i++;
      }
    return k;
    }
}
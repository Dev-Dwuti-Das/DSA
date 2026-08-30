class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] res = new int[2];

      for(int i = 0; i < nums.length; i++){
        if(map.containsKey(target - nums[i])){
          int val1 = map.get(target - nums[i]);
          return new int[]{val1, i};
        }
        map.put(nums[i], i);
      }
    return new int[]{0 ,0};
    }
}
class Solution {
    public int numIdenticalPairs(int[] nums) {
      int count = 0;
      HashMap<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i < nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
      }
      for(int val : map.values()){
        count += (val*(val-1))/2;
      }
    return count;
    }
}
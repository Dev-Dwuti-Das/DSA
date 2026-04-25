class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      int[] prefix = new int[nums.length];
      int count = 0;
      prefix[0] = nums[0];
      for(int i = 1; i < nums.length; i++){
        prefix[i] =  prefix[i-1] + nums[i];
      }

      Map <Integer, Integer> map = new HashMap<>();
      for(int j = 0; j < nums.length; j++){
        if(prefix[j]%k == 0) count++;
        int rem = ((prefix[j] % k) + k)%k;
        if(map.containsKey(rem)){
          count += map.get(rem);
        }
        map.put(rem, map.getOrDefault(rem, 0) + 1);
      }
    return count; 
    }
}
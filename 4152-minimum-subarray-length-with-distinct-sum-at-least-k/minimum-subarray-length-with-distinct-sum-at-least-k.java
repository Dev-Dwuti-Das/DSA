class Solution {
    public int minLength(int[] nums, int k) {
      int min = Integer.MAX_VALUE;
      Map <Integer, Integer> map = new HashMap<>();
      int l = 0;
      int curr_sum = 0;
      for(int r = 0; r < nums.length; r++){

        map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
        if(map.get(nums[r]) == 1){
          curr_sum += nums[r];
        }

        while(curr_sum >= k){
          min = Math.min(min, r - l + 1);
          map.put(nums[l], map.get(nums[l]) - 1);

          if(map.get(nums[l]) == 0){
           
            curr_sum -= nums[l];
             map.remove(nums[l]);
          }
          l++;
        }
      }
    return min == Integer.MAX_VALUE ? -1 : min;
    }
}
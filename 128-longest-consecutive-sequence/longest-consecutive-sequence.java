class Solution {
    public int longestConsecutive(int[] nums) {
      int count = 0;
      HashSet<Integer> set = new HashSet<>();
      for(int num : nums){
        set.add(num);
      }

      for(int val : set){
        if(set.contains(val-1)) continue;
        int temp = val;
        int tempcount = 0;
        while(set.contains(temp)){
          tempcount++;
          count = Math.max(count, tempcount);
          temp++;
        }
      }

    return count; 
    }
}
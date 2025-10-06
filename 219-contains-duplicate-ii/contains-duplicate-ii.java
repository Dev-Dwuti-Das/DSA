class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 1){
            return false;
        }
        int l = 0;
        int r = 0;
        while(r < nums.length && r <= l+k){
            if(set.contains(nums[r])){
                return true;

            }else{
                set.add(nums[r]);
            }
            r++;
        }
        while(r < nums.length){
            set.remove(nums[l]);
            l++;
            
            if(set.contains(nums[r])){
                return true;

            }else{
                set.add(nums[r]);
            }
            r++;
            
        }
    return false;
    }
}
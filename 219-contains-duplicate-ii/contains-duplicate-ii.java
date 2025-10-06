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
        System.out.print("starting set" + set);
        while(r < nums.length){
            set.remove(nums[l]);
            l++;
            
            if(set.contains(nums[r])){
                System.out.print("index:"+ r +" " + nums[r]+ " ");
                System.out.print("after set" + set);
                return true;

            }else{
                set.add(nums[r]);
            }
            r++;
            
        }
        System.out.print("after set" + set);
    return false;
    }
}
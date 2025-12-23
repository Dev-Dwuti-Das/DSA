class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length == 1){
            return;
        }
        int idx = nums.length-k%nums.length;
       
        for(int i = idx; i < nums.length; i++){
            res.add(nums[i]);
        }
        for(int i = 0; i < idx; i++){
            res.add(nums[i]);
        }    

        for(int i = 0; i < res.size(); i++){
            nums[i] = res.get(i);
        }
    }
}
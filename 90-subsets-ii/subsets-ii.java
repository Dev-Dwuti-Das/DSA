class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0 ,temp, res);
        return res;
    }

    public void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> res){

            res.add(new ArrayList<>(temp));


        for(int j = i; j < nums.length; j++){
            if(j > i &&  nums[j] == nums[j-1]){
                continue;
            }
            temp.add(nums[j]);
            helper(nums, j+1, temp, res);
            temp.remove(temp.size()-1);
        }

    }
}
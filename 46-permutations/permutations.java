class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] bool = new boolean[nums.length];
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<List<Integer>> res= new ArrayList<>();
        helper(nums, bool, temp, res);
        return res;

    }

    public void helper(int[] nums, boolean[] bool, ArrayList<Integer> temp, ArrayList<List<Integer>> res){
            if( temp.size() == nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }

            for(int j = 0; j < nums.length; j++){
                if(bool[j]){    //bhara hua h to 
                continue;
                }
                //khali
                bool[j] = true;
                temp.add(nums[j]);
                helper(nums, bool, temp, res);
                bool[j] = false;
                temp.remove(temp.size()-1);
            }


    }
}
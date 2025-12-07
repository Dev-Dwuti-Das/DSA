class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] bool = new boolean[nums.length];
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<List<Integer>> res= new ArrayList<>();
        helper(nums, bool, temp, res);
        return res;

    }

    public void helper(int[] nums, boolean[] bool, ArrayList<Integer> temp, ArrayList<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (bool[j]) continue;
            if ( j>0 && nums[j] == nums[j - 1 ] && !bool[j-1]) { //!bool[j-1] agar purana chala hua h to yeah wla mt chala   
                continue;
            }
            //khali
            bool[j] = true;
            temp.add(nums[j]);
            helper(nums, bool, temp, res);
            bool[j] = false;
            temp.remove(temp.size() - 1);
        }

    }
}
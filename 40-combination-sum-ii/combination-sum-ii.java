class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, target, 0, 0, list, res);

        return res;
    }

    public void helper(int[] nums, int target, int i, int sum, List<Integer> list, List<List<Integer>> res) {
        
            if (sum == target) {
                res.add(new ArrayList<>(list));
                 return;
            }
           
        

        if (sum > target)
            return;

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]){
                continue;
            }
            list.add(nums[j]);
            helper(nums, target, j + 1, sum + nums[j], list, res);
            list.remove(list.size() - 1);
        }
    }
}
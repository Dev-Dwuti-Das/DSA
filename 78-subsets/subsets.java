class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        csubset(nums, 0, ls, res, n, set);
        return res;
    }

    public void csubset(int[] nums, int i, List<Integer> ls, List<List<Integer>> res, int n, Set<List<Integer>> set){
        if(i >= n){
            if(set.add(new ArrayList<>(ls))){
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        ls.add(nums[i]);
        csubset(nums, i+1, ls, res, n, set);
        ls.remove(ls.size() - 1);
        csubset(nums, i+1, ls, res, n, set);
    }

}
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);

    helper(0, res, temp, nums, set);
    return res;

  }

  public void helper(int i, List<List<Integer>> res, List<Integer> temp, int[] nums, Set<List<Integer>> set) {
    if (i >= nums.length) {
      if (set.add(temp)) {
        res.add(new ArrayList<>(temp));
      }
    return;
    }
    temp.add(nums[i]);
    helper(i + 1, res, temp, nums, set);
    temp.remove(temp.size() - 1);
    helper(i + 1, res, temp, nums, set);
  }
}
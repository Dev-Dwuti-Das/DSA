class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    helper(0, res, temp, nums);
    return res;
  }

  public void helper(int i, List<List<Integer>> res, List<Integer> temp, int[] nums) {
    if (i >= nums.length){
      res.add(new ArrayList<>(temp));
      return;
    }
    temp.add(nums[i]);
    helper(i + 1, res, temp, nums);
    temp.remove(temp.size() - 1);
    helper(i + 1, res, temp, nums);
  }
}
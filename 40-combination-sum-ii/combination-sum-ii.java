class Solution {
  public List<List<Integer>> combinationSum2(int[] cand, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(cand);
    helper(0, res, temp, cand, target);
    return res;
  }

  public void helper(int i, List<List<Integer>> res, List<Integer> temp, int[] nums, int sum) {

    if (sum == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int j = i; j < nums.length; j++) {
      if (i < j && nums[j - 1] == nums[j]) continue;
      if(nums[j] > sum) break;
      
      temp.add(nums[j]);
      helper(j + 1, res, temp, nums, sum - nums[j]);
      temp.remove(temp.size() - 1);
    }

  }
}
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(nums);
    helper(0, res, temp, nums);
    return res;

  }

  public void helper(int i, List<List<Integer>> res, List<Integer> temp, int[] nums) {
    res.add(new ArrayList<>(temp));
    for(int j = i; j < nums.length; j++){
      if(j > i && nums[j-1] == nums[j]) continue;

      temp.add(nums[j]);
      helper(j + 1, res, temp, nums);
      temp.remove(temp.size()-1);
    }
  }
}
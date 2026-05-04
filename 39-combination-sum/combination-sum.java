class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    helper(0, temp, res, candidates, target);
    return res;
  }

  public void helper(int i, List<Integer> temp, List<List<Integer>> res, int[] cand, int target) {
    if(i >= cand.length || target < 0) return;
    if (i < cand.length && target == 0){
     res.add(new ArrayList<>(temp));
     return;
    }
    temp.add(cand[i]);
    helper(i, temp, res, cand, target - cand[i]);
    temp.remove(temp.size() - 1);
    helper(i + 1, temp, res, cand, target);
  }
}
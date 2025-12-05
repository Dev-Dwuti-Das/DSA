class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = target;
        helper(cand, target, 0, sum, res, temp);
        return res;
    }

    public void helper(int[] cand, int target, int i, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (i > cand.length - 1) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
                return;
            }
            return;
        }

        if (sum < 0) return;
        temp.add(cand[i]);
        sum -= cand[i];
        helper(cand, target, i, sum, res, temp);

        temp.remove(temp.size() - 1);
        sum += cand[i];

        helper(cand, target, i + 1, sum, res, temp);
    }
}
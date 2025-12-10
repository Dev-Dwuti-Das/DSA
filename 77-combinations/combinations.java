class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res  =  new ArrayList<>();
        helper(1, temp, res, n, k);
        return res;
    }

    public void helper(int i, List<Integer> temp, List<List<Integer>> res, int n, int k){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j < n+1; j++){
            temp.add(j);
            helper(j+1, temp, res, n, k);
            temp.remove(temp.size()-1);
        }
    }
}
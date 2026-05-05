class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<Integer> temp = new ArrayList<>();
      List<List<Integer>> res = new ArrayList<>();
      boolean[] visited = new boolean[nums.length];
      helper(nums, temp, res, visited);
      return res;
    }

    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited){
      if(temp.size() == nums.length){
        res.add(new ArrayList<>(temp));
        return;
      }
      for(int j = 0; j < nums.length; j++){
        if(visited[j]) continue;
        visited[j] =  true;
        temp.add(nums[j]);
        helper(nums, temp, res, visited);
        temp.remove(temp.size()-1);
        visited[j] =  false;
      }
    }
}
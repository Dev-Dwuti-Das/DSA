class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      int diff = Math.abs(nums[i + 1] - nums[i]);
      min = Math.min(min, diff);
      System.out.println(min);
    }

    for (int i = 0; i < nums.length - 1; i++) {
      int diff = Math.abs(nums[i + 1] - nums[i]);
      if(diff == min){
        res.add(Arrays.asList(nums[i], nums[i + 1]));
      }
      min = Math.min(min, diff);
    }
    return res;
  }
}
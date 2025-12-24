class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    for (int pivot = 0; pivot < nums.length - 2; pivot++) {
      int l = pivot + 1;
      int r = nums.length - 1;
      while (l < r) {
        if (nums[l] + nums[r] + nums[pivot] == 0) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[l]);
          temp.add(nums[r]);
          temp.add(nums[pivot]);
          if (set.add(temp)) {
            res.add(temp);
          }
          l++;
          r--; //yeah yaaad kari
        } else if (nums[l] + nums[r] + nums[pivot] > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return res;
  }
}
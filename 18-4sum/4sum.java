class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int p1 = 0; p1 < n - 3; p1++) {
      if (p1 > 0 && nums[p1 - 1] == nums[p1])
        continue;
      for (int p2 = n - 1; p2 > p1 + 2; p2--) {
        if (p2 < n - 1 && nums[p2 + 1] == nums[p2])
          continue;
        int l = p1 + 1;
        int r = p2 - 1;
        while (l < r) {
          long sum_4 = (long)nums[p1] + nums[p2] + nums[l] + nums[r];
          if (sum_4 == target) {
            res.add(Arrays.asList(nums[p1], nums[l], nums[r], nums[p2]));

            r--;
            l++;
            while (l < r && nums[l - 1] == nums[l])
              l++;
            while (l < r && nums[r + 1] == nums[r])
              r--;
          } else if (sum_4 > target) {
            r--;
          } else {
            l++;
          }
        }
      }
    }
    return res;
  }
}
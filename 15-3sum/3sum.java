class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);

    if (nums.length == 3) {
      if (nums[0] + nums[1] + nums[2] == 0) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        temp.add(nums[1]);
        temp.add(nums[2]);
        res.add(temp);
        return res;
      }
    }

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
         List<Integer> temp = new ArrayList<>();
        if (nums[i] + nums[left] + nums[right] == 0) {
          temp.add(nums[i]);
          temp.add(nums[left]);
          temp.add(nums[right]);
          if (set.add(temp)) {
            res.add(temp);
          }
          left++;
          right--;
        } else if (nums[i] + nums[left] + nums[right] < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
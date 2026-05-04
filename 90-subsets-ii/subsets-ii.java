import java.util.*;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums); // ⚠️ important (ensures consistent ordering)
    helper(0, nums, new ArrayList<>(), set);
    return new ArrayList<>(set);
  }

  public void helper(int i, int[] nums, List<Integer> temp, Set<List<Integer>> set) {
    if (i >= nums.length) {
      set.add(new ArrayList<>(temp)); // ✅ always add copy
      return;
    }

    // 👉 TAKE
    temp.add(nums[i]);
    helper(i + 1, nums, temp, set);

    // 👉 BACKTRACK
    temp.remove(temp.size() - 1);

    // 👉 NOT TAKE
    helper(i + 1, nums, temp, set);
  }
}
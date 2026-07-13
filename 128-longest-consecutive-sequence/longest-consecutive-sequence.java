class Solution {
  public int longestConsecutive(int[] nums) {
    int max = Integer.MIN_VALUE;
    Set<Integer> set = new HashSet<>();
    for (int x : nums) {
      set.add(x);
    }

    for (int val : set) {
      if (set.contains(val - 1))
        continue;
      int temp = val;
      int count = 0;
      while (set.contains(temp)) {
        count++;
        max = Math.max(count, max);
        temp++;
      }
    }
    return max == Integer.MIN_VALUE ? 0 : max;
  }
}
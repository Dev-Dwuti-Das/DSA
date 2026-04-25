class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    int[] prefix = new int[nums.length];
    if (nums.length < 2)
      return false;
    prefix[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int j = 0; j < nums.length; j++) {
      int rem = prefix[j] % k;

      System.out.println(rem);
      if (map.containsKey(rem) && (j - map.get(rem)) >= 2) {
        return true;
      }

      if (!map.containsKey(rem)) {
        map.put(rem, j); // ✅
      }
    }

    return false;
  }
}
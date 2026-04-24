class Solution {
  public int subarraySum(int[] nums, int k) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = 0; j < nums.length; j++) {
      if (prefix[j] == k)
        count++;
      int sub_value = prefix[j] - k;
      if (map.containsKey(sub_value)) {
        count += map.get(sub_value);
      }
      map.put(prefix[j], map.getOrDefault(prefix[j], 0) + 1);

    }
    return count;
  }
}
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int max_count = 0;
    Set<Character> set = new HashSet<>();
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      if (set.add(s.charAt(r))) {
        max_count = Math.max(max_count, r - l + 1);
      } else {
        while (!set.add(s.charAt(r))) {
          set.remove(s.charAt(l));
          l++;
        }
      }
    }
    return max_count;
  }
}
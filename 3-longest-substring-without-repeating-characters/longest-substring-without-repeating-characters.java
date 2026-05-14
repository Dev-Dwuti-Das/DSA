class Solution {
    public int lengthOfLongestSubstring(String s) {
      int left = 0;
      int right = 0;
      int max = Integer.MIN_VALUE;
      HashSet<Character> set = new HashSet<>();

      while(right < s.length()){
        while(set.contains(s.charAt(right))){
          set.remove(s.charAt(left));
          left++;
        }
        max = Math.max(max, right - left + 1);
        set.add(s.charAt(right));
        right++;
      }
    return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}
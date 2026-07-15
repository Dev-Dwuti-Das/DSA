class Solution {
    public int lengthOfLongestSubstring(String s) {
      int right = 0;
      int left = 0;
      int maxi = Integer.MIN_VALUE;
      Set<Character> set = new HashSet<>();

      while(right < s.length()){
        while(set.contains(s.charAt(right))){
          set.remove(s.charAt(left));
          left++;
        }
        set.add(s.charAt(right));
        maxi = Math.max(right - left + 1, maxi);
        right++;
      }
      return maxi == Integer.MIN_VALUE ? 0 : maxi;
        
    }
}
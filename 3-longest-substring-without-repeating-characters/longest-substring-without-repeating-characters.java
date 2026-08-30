class Solution {
    public int lengthOfLongestSubstring(String s) {
      int l = 0;
      int r = 0;
      Set <Character> set = new HashSet<>();
      int res = Integer.MIN_VALUE;

      while(r < s.length()){
        while(r < s.length() && !set.contains(s.charAt(r))){
          set.add(s.charAt(r));
          r++;
        }
        res = Math.max(res, set.size());

        while(r < s.length() && set.contains(s.charAt(r))){
          set.remove(s.charAt(l));
          l++;
        }
      } 
    return res == Integer.MIN_VALUE ? 0 : res;
    }
}
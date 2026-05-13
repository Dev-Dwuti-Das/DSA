class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      if(p.length() > s.length()) return new ArrayList<>();
      int[] freq_s = new int[26];
      int[] freq_p = new int[26];
      List<Integer> res = new ArrayList<>();
      for(char c : p.toCharArray()){
        freq_p[c - 'a']++;
      }
      int left = 0;
      int right = 0;

      while(right < s.length()){
        while(right - left + 1 < p.length()){
          freq_s[s.charAt(right) - 'a']++;
          right++;
        }
        freq_s[s.charAt(right) - 'a']++;
        if(Arrays.equals(freq_s, freq_p)){
          res.add(left);
        }
        freq_s[s.charAt(left) - 'a']--;
        left++;
        right++; 
      } 
    return res;       
    }
}
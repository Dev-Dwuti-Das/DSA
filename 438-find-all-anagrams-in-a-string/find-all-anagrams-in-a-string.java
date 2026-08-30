class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int[] s_arr = new int[26];
      int[] p_arr = new int[26];
      List<Integer> res = new ArrayList<>();
      if(p.length() > s.length()) return new ArrayList<>();

      for(char c : p.toCharArray()){
        p_arr[c - 'a']++;
      }

      int l = 0;
      int r = 0;

      while(r < s.length()){
        while(r - l < p.length()){
          s_arr[s.charAt(r) - 'a']++;
          r++;
        }
        if(Arrays.equals(s_arr, p_arr)){
          res.add(l);
        }
        s_arr[s.charAt(l) - 'a']--;
        l++;
      }
    return res;
    }
}
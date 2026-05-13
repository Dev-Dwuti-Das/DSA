class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length() > s2.length()) return false;
      int[] freq_s1 = new int[26];
      int[] freq_s2 = new int[26];
      List<Integer> res = new ArrayList<>();
      for(char c : s1.toCharArray()){
        freq_s1[c - 'a']++;
      }
      int left = 0;
      int right = 0;

      while(right < s2.length()){
        while(right - left + 1 < s1.length()){
          freq_s2[s2.charAt(right) - 'a']++;
          right++;
        }
        freq_s2[s2.charAt(right) - 'a']++;
        if(Arrays.equals(freq_s1 , freq_s2)){
          return true;
        }
        freq_s2[s2.charAt(left) - 'a']--;
        left++;
        right++;
      }
    return false; 
    }
}
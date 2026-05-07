class Solution {
    public boolean canConstruct(String ransom, String mag) {
      int[] freq = new int[26];

      for(char c : mag.toCharArray()){
        freq[c - 'a']++;
      }

      for(char s : ransom.toCharArray()){
        freq[s - 'a']--;
        if(freq[s-'a'] < 0) return false;
      }
    return true;  
    }
}
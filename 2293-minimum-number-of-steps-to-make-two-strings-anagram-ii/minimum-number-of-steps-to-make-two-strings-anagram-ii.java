class Solution {
    public int minSteps(String s, String t) {
      int[] freq = new int[26];
      int count = 0;

      for(char c : s.toCharArray()){
        freq[c - 'a']++;
      }

      for(char x : t.toCharArray()){
        freq[x - 'a']--;
      }

      for(int val : freq){
        count += Math.abs(val);
      }

    return count;
    }
}
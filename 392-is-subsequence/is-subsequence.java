class Solution {
    public boolean isSubsequence(String s, String t) {
      int s_index = 0;
      int t_index = 0;
      int count = 0;

      while(s_index < s.length() && t_index < t.length()){
        if(s.charAt(s_index) == t.charAt(t_index)){
          count++;
          s_index++;
          t_index++;
        }else{
          t_index++;
        }

      }
      if(count == s.length()) return true;
    return false;
    }
}
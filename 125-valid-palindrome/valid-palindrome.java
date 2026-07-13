class Solution {
    public boolean isPalindrome(String s) {
      String s1 = s.trim().toLowerCase().replaceAll("[^A-Za-z0-9]","");
      StringBuilder sb = new StringBuilder(s1);
      return sb.reverse().toString().equals(s1);
        
    }
}
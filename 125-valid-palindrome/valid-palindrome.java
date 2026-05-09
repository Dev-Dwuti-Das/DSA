class Solution {
    public boolean isPalindrome(String s) {
      String st1 = s.replaceAll("[^A-Za-z0-9]","");
      String st2 = s.replaceAll("[^A-Za-z0-9]","");
      String st12 = st1.toLowerCase();
      String st22 = st2.toLowerCase();
      StringBuilder sb1 = new StringBuilder(st12).reverse();
      return st12.equals(sb1.toString());
    }
}
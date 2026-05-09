class Solution {
    public String longestCommonPrefix(String[] strs) {
      if(strs.length <= 1) return strs[0];
      if(strs[0].equals("")) return "";
      Arrays.sort(strs);
      StringBuilder res = new StringBuilder();
      String st1 = strs[0];
      String st2 = strs[strs.length-1];
      int i = 0;
      int n = Math.min(st1.length(), st2.length());
      while(i < n){
        if(st1.charAt(i) == st2.charAt(i)){
          res.append(st1.charAt(i));
        }else{
          break;
        }
        i++;
      }
      return res.toString();
    }
}
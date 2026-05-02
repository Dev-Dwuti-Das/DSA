class Solution {
    public String reverseWords(String s) {
      String st = s.trim();
      String[] starry = st.split("\\s+");
      StringBuilder sb = new StringBuilder();
      for(int i = starry.length-1; i >= 0; i--){
        sb.append(starry[i]);
        sb.append(" ");
      }

      return sb.toString().trim();
    }
}
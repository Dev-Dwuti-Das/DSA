class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      List<String> temp = new ArrayList<>();
      helper(0, s, temp, res);
      return res;
    }

    public void helper(int i, String s, List<String> temp, List<List<String>> res){
      if(i == s.length()) res.add(new ArrayList<>(temp));
      for(int j = i; j < s.length(); j++){
        String sub = s.substring(i, j+1);
        if(ispalin(sub)){
          temp.add(sub);
          helper(j+1, s, temp, res);
          temp.remove(temp.size()-1);
        }
      }
    }

    public boolean ispalin(String s){
      StringBuilder sb = new StringBuilder(s);
      sb.reverse();
      if(s.equals(sb.toString())) return true;
      return false;
    }
}
class Solution {
    public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    String[] list = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    helper(0, res, digits, list, "");
    return res;
    }

    public void helper(int i , List<String> res, String digit, String[] list, String temp){
      if(temp.length() == digit.length()){
        res.add(temp);
        return;
      }
      int key = digit.charAt(i) - '0';
      String st = list[key];
      char[] ch = st.toCharArray();
      for(int j = 0; j < ch.length; j++){
        helper(i+1, res, digit, list, temp+ch[j]);
      }
    }
}


// for(char c : ch){
      //   helper(i+1, res, digit, list, temp+c);
      // }
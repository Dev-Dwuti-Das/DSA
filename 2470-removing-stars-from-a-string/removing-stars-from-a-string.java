class Solution {
    public String removeStars(String s) {
      Stack <Character> st = new Stack<>();
      StringBuilder sb = new StringBuilder();


      for(char c : s.toCharArray()){
        if(c == '*'){
          st.pop();
        }else{
          st.push(c);
        }
      }

      for(char x : st){
        sb.append(x);
      }
    return sb.toString();        
    }
}
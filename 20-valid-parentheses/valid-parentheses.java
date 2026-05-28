class Solution {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    if (s.length() % 2 != 0) return false;

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        st.push(c);
      } else {
        if (st.isEmpty()) { //yeah mt bhool lavde
          return false;
        }
        int top = st.pop();
        if (c == ')' && top != '(') {
          return false;
        }
        if (c == ']' && top != '[') {
          return false;
        }
        if (c == '}' && top != '{') {
          return false;
        }
      }
    }
    return st.isEmpty();
  }

}

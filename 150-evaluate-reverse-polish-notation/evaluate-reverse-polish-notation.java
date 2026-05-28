class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();
    for (String s : tokens) {
      if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
        int num1 = st.pop();
        int num2 = st.pop();
        int val = calculate(num2, num1, s);
        st.push(val);
      } else {
        st.push(Integer.parseInt(s));
      }
    }    
    return st.peek();
  }

  public int calculate(int a, int b, String s) {
    if (s.equals("+")) {
      return a + b;
    } else if (s.equals("*")) {
      return a * b;
    } else if (s.equals("-")) {
      return a - b;
    } else {
      return a / b;
    }
  }
}
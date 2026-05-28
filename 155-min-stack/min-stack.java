class MinStack {
  Deque<Integer> st;
  Deque<Integer> min;
  int min_val = Integer.MAX_VALUE;

  public MinStack() {
    st = new ArrayDeque<>();
    min = new ArrayDeque<>();
  }

  public void push(int val) {
    st.push(val);
    if (min_val >= val) {
      min.push(val);
      min_val = val;
    }
  }

  public void pop() {
    int val = st.pop();
    if (val == min.peek()) {
      min.pop();
      if (st.isEmpty()) {
        min_val = Integer.MAX_VALUE;
      } else {
        min_val = min.peek();
      }
    }
  }

  public int top() {
    return st.peek();
  }

  public int getMin() {
    return min.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
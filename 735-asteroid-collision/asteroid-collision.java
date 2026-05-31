class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();
    for (int val : asteroids) {

      while (!st.isEmpty() && st.peek() > 0 && val < 0 && Math.abs(val) > st.peek()) {
        st.pop();
      }
      if (!st.isEmpty() && st.peek() > 0 && val < 0) {
        if (st.peek() == Math.abs(val)) {
          st.pop();
        }
      }else{
        st.add(val);
      }
    }

    int[] res = new int[st.size()];
    for (int i = st.size() - 1; i >= 0; i--) {
      res[i] = st.pop();
    }
    return res;

  }
}
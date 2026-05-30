class Solution {
    public int[] dailyTemperatures(int[] temp) {
      int[] res = new int[temp.length];
      Stack <Integer> st = new Stack<>();


      for(int j = temp.length-1; j >= 0; j--){

        while(!st.isEmpty() && temp[j] >= temp[st.peek()]){
          st.pop();
        }

        int val = (st.isEmpty() == true) ? 0 : st.peek() - j;
        res[j] = val;
        st.push(j);
      }

      return res;
        
    }
}
class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
      Stack <Double> st = new Stack<>();
      int[][] mat = new int[pos.length][2];

      for(int i = 0; i < pos.length; i++){
        mat[i][0] = pos[i];
        mat[i][1] = speed[i];
      }

      Arrays.sort(mat,(a,b) -> Integer.compare(a[0], b[0]));

      for(int i = pos.length-1; i >= 0; i--){
        double time = (double)(target - mat[i][0])/mat[i][1];

        if(!st.isEmpty() && time <= st.peek()){
          continue;
        } 
        st.push(time);
      }
    return st.size();
        
    }
}
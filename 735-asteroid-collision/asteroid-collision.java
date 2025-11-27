class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ast.length; i++) {
            boolean destroyed = false;
            while (!st.isEmpty() && ast[i] < 0 && st.peek() > 0) {
                int diff = ast[i] + st.peek();
                if(diff < 0){
                    st.pop();
                }
                else if ( diff == 0){
                    destroyed = true;
                    st.pop();
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(ast[i]);
            }
            
        }
        int res[] = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            res[i] = st.get(i);
        }
        return res;
    }
}
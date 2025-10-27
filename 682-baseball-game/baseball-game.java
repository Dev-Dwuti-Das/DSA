class Solution {
    public int calPoints(String[] operations) {
        Stack < Integer > st = new Stack<>();
        int sum = 0;
        for(String C : operations){
            if(C.equals("+")){
                int top = st.pop();
                int add = st.peek() + top;
                st.push(top);
                st.push(add);
            }

            else if(C.equals("D")){
                int temp = 2*(st.peek());
                st.push(temp);
            }

            else if(C.equals("C")){
                st.pop();

            }
            else{
                st.push(Integer.parseInt(C));
            }
        }

        for(Integer s : st){
            sum = sum + s;
        }
        
    return sum;
    }
}
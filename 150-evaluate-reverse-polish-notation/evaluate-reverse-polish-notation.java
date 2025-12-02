class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/") && !tokens[i].equals("*")){
                stack.push(tokens[i]);
            }
            else if(!stack.isEmpty()){
                int pop1 = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                int temp_res = 0;
                if(tokens[i].equals("+")){
                    temp_res = pop1+pop2;
                }
                if(tokens[i].equals("-")){
                    temp_res = pop2-pop1;
                }
                if(tokens[i].equals("*")){
                    temp_res = pop1*pop2;
                }
                if(tokens[i].equals("/")){
                    temp_res = pop2/pop1;
                }
                stack.push(String.valueOf(temp_res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
class MinStack {
    Stack <Integer> stack;
    Stack <Integer> minstack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        if(val < min){
            min = val;
        }
        stack.push(val);
        minstack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();    
        if(stack.isEmpty()){
            min = Integer.MAX_VALUE;
        }
        else{
            min = minstack.peek();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek(); 
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
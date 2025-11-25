class MyStack {
    Queue <Integer> Q1;

    public MyStack() {
        Q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        Q1.add(x);
    }
    
    public int pop() {
        int size = Q1.size();
        for(int i = 1; i < size; i++){
            Q1.add(Q1.poll());
        }
        return Q1.poll();
    }

    public int top() {
        int size = Q1.size();
        for(int i = 1; i < size; i++){
            Q1.add(Q1.poll());
        }
        int val = Q1.poll();
        Q1.add(val);
        return val;
    }
    
    public boolean empty() {
        return Q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
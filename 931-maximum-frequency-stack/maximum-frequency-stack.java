class FreqStack {
    Map <Integer , Integer> count;
    Map <Integer , Stack<Integer>> stack;
    int max_count = 0;

    public FreqStack() {
        count = new HashMap<>();
        stack =  new HashMap<>();
    }
    
    public void push(int val) {
        int cur_count = count.getOrDefault(val, 0)+1;
        count.put(val , cur_count);

        if(cur_count > max_count){
            max_count = cur_count;
            stack.putIfAbsent(cur_count, new Stack<>());
        }
        stack.get(cur_count).push(val);
    }
    
    public int pop() {
        int res = stack.get(max_count).pop();
        count.put(res, count.get(res)-1);
        if(stack.get(max_count).isEmpty()){
            max_count--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
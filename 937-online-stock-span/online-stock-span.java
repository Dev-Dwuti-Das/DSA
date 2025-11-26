class StockSpanner {
    Stack <Integer> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        stack.push(price);
        int count = 0;
        int i = stack.size()-1;
        int size = stack.size();
        while(size > 0 && i >= 0 && stack.get(i) <= price){
            count++;
            i--;
            size--;
        } 
    return count; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
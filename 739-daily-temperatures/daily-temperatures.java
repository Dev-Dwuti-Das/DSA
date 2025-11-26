class Solution {
    public int[] dailyTemperatures(int[] temp){
        int[] res = new int[temp.length];
        Stack <Integer> stack = new Stack<>();

        for(int i = 0; i < temp.length; i++){
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        } 

    return res;
        
    }
}
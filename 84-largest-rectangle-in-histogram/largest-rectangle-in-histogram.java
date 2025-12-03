class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack <Integer> stack = new Stack<>();
        int max_area = 0;
        int n = heights.length;

        for(int i = 0; i <= heights.length; i++){
            while(!stack.isEmpty() && ( i == n || heights[stack.peek()] >= heights[i])){
                int ht = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max_area = Math.max(max_area, ht*width); 
            }
            stack.push(i);
        }

        return max_area;
        
    }
}
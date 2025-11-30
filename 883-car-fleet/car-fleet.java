class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
       int n = pos.length;
       Stack <Double> stack = new Stack<>();
       int[][] cars = new int[n][2];

       for(int i = 0; i < n; i ++){
        cars[i][0] = pos[i];
        cars[i][1] = speed[i];
       }
        
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);

        for(int i = 0; i < n; i++){
            boolean flag = false;
            double time = (double)(target - cars[i][0])/cars[i][1];
            if(!stack.isEmpty() && time <= stack.peek()){
                flag = true;
            }
            if(!flag){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
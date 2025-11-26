class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack <Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);


        for(int i = 0; i < 2*nums.length-1; i++){
            int idex = i%n;
            while(!stack.isEmpty() && nums[idex] > nums[stack.peek()]){
                int pop_idex = stack.pop();
                res[pop_idex] = nums[idex];
            }
            stack.push(idex);
        }
    return res;
    }

}
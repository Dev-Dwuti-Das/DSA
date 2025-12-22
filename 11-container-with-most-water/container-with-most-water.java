class Solution {
    public int maxArea(int[] height) {
        int max_water = Integer.MIN_VALUE;
        int curr_water = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r){
            curr_water = Math.min(height[l], height[r])*(r - l);
            max_water = Math.max(max_water, curr_water);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }




    return max_water;   
    }
}
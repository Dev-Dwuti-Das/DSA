class Solution {
    public int maxArea(int[] height) {
       int i = 0;
       int j = height.length-1;
       int max_water = 0;
       while(i < j){
            int curr = Math.min(height[i],height[j])*(j-i);
            max_water = Math.max(max_water,curr);

            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
       }
    return max_water;
    }
}
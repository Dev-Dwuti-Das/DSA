class Solution {
    public int maxArea(int[] height) {
      int left = 0;
      int right = height.length-1;
      int max = Integer.MIN_VALUE;
      while(left < right){
        int width = right - left;
        int hei = Math.min(height[left],height[right]); 
        int curr_vol = hei * width;
        max = Math.max(max, curr_vol); 
        if(height[left] < height[right]){
          left++;
        }else{
          right--;
        }
      }   
    return max;     
    }
}
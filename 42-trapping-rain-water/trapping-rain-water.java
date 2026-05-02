class Solution {
    public int trap(int[] height) {
      int n = height.length;
      int[] pre = new int[n];
      int[] post = new int[n];
      int water = 0;
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;

      for(int i = 0; i < n; i++){
        int val1 = height[i];
        int val2 = height[n-1-i];
        max1 = Math.max(max1, val1);  
        max2 = Math.max(max2, val2);
        pre[i] = max1;  
        post[n-1-i] = max2;  
      }

      for(int j = 0; j < n; j++){
        water += Math.min(pre[j], post[j]) - height[j];
      }
      return water;
        
    }
}
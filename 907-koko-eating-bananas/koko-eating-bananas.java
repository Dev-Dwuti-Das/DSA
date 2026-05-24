class Solution {
    public int minEatingSpeed(int[] piles, int h) {

      int[] temp = piles.clone();
      Arrays.sort(piles);
      int min = 1;
      int max = piles[piles.length-1];

      while(min < max){
        int mid = (min+max)/2;
        int val = isvalid(temp, mid, h);

        if( val > h){ //taking more time
          min = mid+1; 
        }else{ //taking less time
          max = mid;
        }
      }
      return min;
    }

    public int isvalid(int[] nums, int mid, int h){
      int time_taken = 0;
      for(int i = 0; i < nums.length; i++){
          if(nums[i]%mid == 0){
            time_taken += nums[i]/mid;
          }else{
            time_taken += nums[i]/mid + 1;
          }
      }
      return time_taken;
    }
}
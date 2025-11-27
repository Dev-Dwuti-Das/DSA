class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length-1];
        int min = 1;

        while(min < max){
            int var_h = h;
            int mid = (max+min)/2; //6
            for(int i = 0; i < piles.length; i++){
                int time_taken = (piles[i] + mid - 1)/mid;
                var_h = var_h - time_taken;
            }
            if(var_h >= 0){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
    return min;
    }
}
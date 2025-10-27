class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length-1; i++){
            int pivot = numbers[i];
            int l = i+1;
            int r = numbers.length-1;
            while( l <= r){
                int mid = (r + l)/2;
                if(pivot + numbers[mid] == target){
                    return new int[]{i+1 , mid+1};
                }
                else if(pivot + numbers[mid] > target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return new int[2];
    }
}
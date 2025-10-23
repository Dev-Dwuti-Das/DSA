class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i]; 
           System.out.print(prefix[i] + " ");
        }
        for(int i = nums.length-2; i > 0 ; i--){
            suffix[i] = suffix[i+1] * nums[i]; 
            // System.out.print(suffix[i] + " ");
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                result[i] = suffix[i+1]; 
            }else if(i == nums.length-1){
                result[nums.length-1] = prefix[i-1];

            }else{
            result[i] = prefix[i-1] * suffix[i+1]; 
            }
            
        }
    return result;
    }
}
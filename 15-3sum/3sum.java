class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List <List<Integer>> result = new ArrayList<>();
        Set <List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++){
            int l = i+1;
            int r = nums.length-1;
            int pivot = nums[i];
            while(l < r){
                if(pivot + nums[l] + nums[r] == 0){
                    List <Integer> temp = new ArrayList<>();
                    temp.add(pivot);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    if(set.add(temp)){
                        result.add(temp);
                    }
                    l++;
                    r--;
                }
                else if(pivot + nums[l] + nums[r] < 0 ){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
    return result;  
    }
}
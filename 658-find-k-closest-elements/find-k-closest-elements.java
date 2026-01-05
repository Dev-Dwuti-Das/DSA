class Solution {
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    int l = 0;
    for (int r = 0; r < nums.length; r++) {
      while (r - l + 1 > k) {
        if (Math.abs(nums[l] - x) > Math.abs(nums[r] - x)) {
          l++;
        }else{
          break;
        }
      }
    }
    List<Integer> res = new ArrayList<>();
    for(int i = l; i < l+k; i++){
      res.add(nums[i]);
    }
    return res;
  }
}
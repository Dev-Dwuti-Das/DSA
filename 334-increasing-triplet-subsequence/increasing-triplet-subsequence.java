class Solution {
  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int val : nums) {
      if (first >= val) {
        first = val;
      } else if (second >= val) {
        second = val;
      } else {
        return true;
      }
    }
    return false;
  }
}
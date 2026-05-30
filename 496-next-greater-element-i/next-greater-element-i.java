class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

      Stack<Integer> st = new Stack<>();
      int[] res = new int[nums1.length];
      Map<Integer, Integer> map = new HashMap<>();

      for(int j = nums2.length-1; j >= 0; j--){

        while(!st.isEmpty() && nums2[j] > st.peek()){
          st.pop();
        }

        int val = (st.isEmpty() == true) ? -1 : st.peek();

        map.put(nums2[j], val);

        st.push(nums2[j]);
      }

      for(int i = 0; i < nums1.length; i++){
        res[i] = map.get(nums1[i]);
      }
      
      return res;
    }
}
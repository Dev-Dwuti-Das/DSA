class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue <Integer> pq = new PriorityQueue<>();
      for(int val : nums){
        pq.offer(val);
      }
      int limit = nums.length - k;
      while(limit > 0){
        System.out.println(pq.poll());
        limit--;
      }
      return pq.poll(); 
    }
}
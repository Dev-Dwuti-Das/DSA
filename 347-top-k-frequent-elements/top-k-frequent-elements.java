class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map <Integer, Integer> map = new HashMap<>();
      for(int val : nums){
        map.put(val, map.getOrDefault(val, 0) + 1);
      }
    
    List<Integer>[] buckets = new ArrayList[nums.length + 1]; //list of arraylist
    for(int keys : map.keySet()){
      int freq = map.get(keys);
      if(buckets[freq] == null){
        buckets[freq] = new ArrayList<>();
      }
      buckets[freq].add(keys);
    }

    List<Integer> res = new ArrayList<>();
    for(int i = buckets.length-1; i >= 0; i--){
      if(res.size() >= k) break;
      if(buckets[i] != null){
        res.addAll(buckets[i]);
      }
    }
    int[] final_result = new int[k];

    for(int j = 0; j < res.size(); j++){
      final_result[j] = res.get(j);
    }

    return final_result;

    }
}

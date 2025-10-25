class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
         List<Integer>[] ls = new ArrayList[nums.length + 1];
        for(Integer C : map.keySet()){
            int freq = map.get(C);
            if(ls[freq] == null){
                ls[freq] = new ArrayList<>();
            }
                ls[freq].add(C);
        }

        ArrayList <Integer> answer = new ArrayList<>();
        for(int i = ls.length-1; i > 0; i--){
            if(ls[i] != null){
                answer.addAll(ls[i]);
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = answer.get(i);
        }
    return res;
    }
}
class Solution {
    public String frequencySort(String s) {
     Map <Character, Integer> map = new HashMap<>();
     for(char ch : s.toCharArray()){
      map.put(ch, map.getOrDefault(ch, 0) + 1);
     }

     ArrayList<Character>[] bucket = new ArrayList[s.length()+1];
     for(char key : map.keySet()){
      int freq = map.get(key);
      if(bucket[freq] == null){
        bucket[freq] = new ArrayList<>();
      }
      bucket[freq].add(key);
     }
     StringBuilder sb = new StringBuilder();
     for(int i = s.length(); i >= 0; i--){
      if(bucket[i] != null){
        for(char c : bucket[i]){
          int f = map.get(c);
          while(f > 0){
            sb.append(c);
            f--;
          }
        }
      }
     }
   return sb.toString(); 
  }
}

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for (String st : strs) {
      char[] ary = st.toCharArray();
      Arrays.sort(ary);
      String sorted = new String(ary);
      if (map.containsKey(sorted)) {
        System.out.println(sorted);
        map.get(sorted).add(st);
      }else {
        map.put(sorted, new ArrayList<>());
        map.get(sorted).add(st);
      }
    }
    for(ArrayList<String> val : map.values()){
      res.add(val);
    }
    return res;
  }
}
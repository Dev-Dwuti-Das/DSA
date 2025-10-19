class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List <String> low = new ArrayList<>();  
        List <List<String>> high = new ArrayList<>();
        Map <String, List> map = new HashMap<>();
        Arrays.sort(strs);
        for(String S: strs){
            char[] temp = S.toCharArray();
            Arrays.sort(temp);
            String temp_string = new String(temp);
            if(!map.containsKey(temp_string)){
                map.put(temp_string, new ArrayList<>());
            }
            map.get(temp_string).add(S);
        }
        return new ArrayList(map.values());
    }
}
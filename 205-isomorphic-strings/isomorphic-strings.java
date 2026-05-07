class Solution {
    public boolean isIsomorphic(String s, String t) {
      if(s.length() != t.length()) return false;
      StringBuilder sb = new StringBuilder();
      Map<Character, Character> map = new HashMap<>();
      Set<Character> set = new HashSet<>();
      for(int i = 0; i < s.length(); i++){
        if(set.add(t.charAt(i))){
          map.put(s.charAt(i), t.charAt(i));
        }
      }
      for(int j = 0; j < s.length(); j++){
        sb.append(map.get(s.charAt(j)));
      }
    System.out.print(sb.toString());
    return sb.toString().equals(t);
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int left = 0;
      int right = p.length() - 1;
      List<Integer> res = new ArrayList<>();

      while(right < s.length()){
        if(anagram(left, right, s, p)){
          res.add(left);
        }
        left++;
        right++;
      } 
      return res;
    }
    // public boolean anagram(int left, int right, String s, String p){
    //   String sub = s.substring(left, right+1);
    //   char[] arry1 = sub.toCharArray();
    //   Arrays.sort(arry1);
    //   String sorted_s = new String(arry1);  
    //   char[] arry2 = p.toCharArray();
    //   Arrays.sort(arry2);
    //   String sorted_p = new String(arry2);  
    //   return sorted_s.equals(sorted_p);
    // }
    public boolean anagram(int left, int right, String s, String p){
      int[] freq = new int[26];
      for(int i = left ; i <= right; i++){
        freq[s.charAt(i) - 'a']++;
      }
      for(char c : p.toCharArray()){
        freq[c - 'a']--;
      }
      for(int x : freq){
        if(x != 0) return false;
      }
      return true;
    }
}
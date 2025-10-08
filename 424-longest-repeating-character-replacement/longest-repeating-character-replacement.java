class Solution {
    public int characterReplacement(String s, int k) {
     int l = 0;
     int max_frequency = 0;
     int max_window_len = 0;
     Map<Character,Integer> map = new HashMap<>();
     for(int r = 0; r < s.length(); r++){
        int length_window = r - l+1;
        map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            for(Integer p : map.values()){
                max_frequency = Math.max(max_frequency, p); 
            }
            if(length_window - max_frequency <= k){
                max_window_len = Math.max(max_window_len,length_window);
            }
            else{
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
        }
        return  max_window_len;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        if (s.equals(t)) return s;

        int l = 0;
        int min_len = Integer.MAX_VALUE;
        int start = 0;
        int[] need = new int[128];
        int[] arry = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        for(int r = 0; r < s.length(); r++){
            arry[s.charAt(r)]++;
            while(containsAll(arry, need)){
                int len = r - l + 1;
                if (len < min_len) {
                    min_len = len;
                    start = l;
                }
                arry[s.charAt(l)]--;
                l++;
            }
        }    
        if (min_len == Integer.MAX_VALUE) return "";
        return s.substring(start,start+min_len);
        
    }
    public boolean containsAll(int[] window, int[] need) {
        for (int i = 0; i < 128; i++) {
            if (need[i] > window[i]) return false;
        }
        return true;
    }
}
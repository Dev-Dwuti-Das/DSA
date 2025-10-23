class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int r = 0;
        List <Integer> ls = new ArrayList<>();
        int[] p_count = new int[26];
        int[] s_count = new int[26];
        for(char c : p.toCharArray()){
            p_count[ c - 'a']++;
        }

        while(r < s.length()){
            s_count[s.charAt(r) - 'a']++;
            if(r >= p.length()){
                s_count[s.charAt(r - p.length()) - 'a']--;
            }
            if(Arrays.equals(s_count,p_count)){
                ls.add(r - p.length() + 1);
            }
            r++;
        }
        return ls;
        
    }
}
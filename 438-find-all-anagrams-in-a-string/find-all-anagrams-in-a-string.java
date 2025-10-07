class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        int[] count_s = new int[26];
        int[] count_p = new int[26];
        int l = 0;
        int r = 0;
        for(char c : p.toCharArray()){
            count_p[c-'a']++;
        }
        while(r < s.length()){
            count_s[s.charAt(r)-'a']++;
            if(r >= p.length()){
                count_s[s.charAt(r-p.length())-'a']--;
            }
            if(Arrays.equals(count_s,count_p)){
                ls.add(r-p.length()+1);
            }
            r++;

        }
        return ls;
    }
}
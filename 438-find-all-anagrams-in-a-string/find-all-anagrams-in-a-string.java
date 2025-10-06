class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        char[] p_list = p.toCharArray();
        Arrays.sort(p_list);
        String p_asc = new String(p_list);
        int l = 0;
        int len_p = p.length()-1; // index --2
        int len_s = s.length()-1; // index --2
        int r = l+len_p;  
        while(r <= len_s){
            String sub_string = s.substring(l,r+1);
            char[] s_list = sub_string.toCharArray();
            Arrays.sort(s_list);
            String s_asc = new String(s_list);
            if(s_asc.equals(p_asc)){
                ls.add(l);
            }
            l++;
            r++;
        }
       return ls;
    }
}
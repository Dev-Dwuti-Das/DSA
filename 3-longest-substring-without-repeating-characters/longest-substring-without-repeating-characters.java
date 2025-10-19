class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int l = 0;
        int max_count = Integer.MIN_VALUE;
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            if(!set.add(s.charAt(r))){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
            }
            count = r - l + 1 ;
            max_count = Math.max(max_count,count);
        }
    return max_count;
    }
}
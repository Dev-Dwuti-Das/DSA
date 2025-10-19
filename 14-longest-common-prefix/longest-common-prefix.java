class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while(i < last.length() && i < first.length() && first.charAt(i) == last.charAt(i)){
            sb.append(first.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
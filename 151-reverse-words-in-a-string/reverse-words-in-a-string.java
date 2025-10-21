class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        StringBuilder answer = new StringBuilder();
        String new_sb = sb.toString();
        String[] temp = new_sb.split(" ");
        for( String S: temp){
            answer.append(new StringBuilder(S).reverse()).append(" ");
        }
        return answer.reverse().toString().replaceAll("\\s+", " ").trim();
    }
}
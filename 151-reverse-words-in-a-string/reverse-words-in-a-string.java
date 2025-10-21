class Solution {
    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] temp = s.split(" ");
        for (String S : temp) {
            answer.append(new StringBuilder(S).reverse()).append(" ");
        }
        return answer.reverse().toString().replaceAll("\\s+", " ").trim();
    }
}
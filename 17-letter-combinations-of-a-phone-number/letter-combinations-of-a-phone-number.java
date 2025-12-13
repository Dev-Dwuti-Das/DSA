class Solution {
    public List<String> letterCombinations(String digits) {
        String[] list = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List <String> res = new ArrayList<>();
        int n = digits.length();
        helper(n, res, "", 0, digits, list); 
        return res;
    }

    public void helper(int n,List <String> res, String temp, int idx, String digits ,String[] list){

        if(temp.length() == n){
            res.add(temp);
            return;
        }

        String chars = list[digits.charAt(idx) - '0'];
        char[] ch_arry =  chars.toCharArray();
        for(Character c : ch_arry){
            helper(n, res, temp+c, idx+1, digits, list);
        } 
    }
}
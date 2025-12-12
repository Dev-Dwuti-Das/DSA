class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, res, 0 , 0, "");
        return res;
    }

    public void helper(int n, List<String> res, int open, int close, String st){
        if(st.length() == 2*n){
            res.add(st);
            return;
        }

        if( open < n){
            helper(n, res, open+1 , close, st+"(");
        }

        if( close < open){
            helper(n, res, open , close+1, st+")");
        }
    }
}
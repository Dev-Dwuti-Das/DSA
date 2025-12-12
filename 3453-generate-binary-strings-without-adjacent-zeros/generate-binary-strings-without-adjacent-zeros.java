class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        helper(n, res, "", "");
        return res;
    }

    public void helper(int n, List<String> res, String st, String prev) {
        if (st.length() == n) {
            res.add(st);
            return;
        }

        if (st.length() < n) {
            helper(n, res, st + "1","1");
        }

        if (prev.equals("") || prev.equals("1")) {
            helper(n, res, st + "0","0");
        }
    }
}
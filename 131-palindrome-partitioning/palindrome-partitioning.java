class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(s, 0, res, temp);
        return res;
    }

    public void backtrack(String st, int i, List<List<String>> res, List<String> temp) {
        if (i == st.length()) {
            res.add(new ArrayList<>(temp));
        }

        for (int j = i; j < st.length(); j++) {
            String substring = st.substring(i, j + 1);
            if (ispal(substring)) {
                temp.add(substring);
                backtrack(st, j+1, res, temp);
                temp.remove(temp.size() - 1);
            }

        }

    }

    public boolean ispal(String st) {
        int r = 0;
        int l = st.length() - 1;
        while (r <= l) {
            if (st.charAt(r) != st.charAt(l)) {
                return false;
            }
            r++;
            l--;
        }
        return true;
    }
}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(s, 0, temp, res, s.length());
        return res;
    }

    public void backtrack(String s, int i, List<String> temp,
                          List<List<String>> res, int n) {

        // ✅ BASE CASE (string fully used)
        if (i == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // 🔁 like you build sb, we build substring
        for (int j = i; j < n; j++) {

            String curr = s.substring(i, j + 1);

            // ✅ palindrome check
            if (isPalindrome(curr)) {
                temp.add(curr);                    // choose
                backtrack(s, j + 1, temp, res, n); // explore
                temp.remove(temp.size() - 1);      // backtrack
            }
        }
    }

    public boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

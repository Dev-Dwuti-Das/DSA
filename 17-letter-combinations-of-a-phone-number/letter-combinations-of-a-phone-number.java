class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        String[] keypad = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(digits, 0, keypad, temp, res);
        return res;
    }

    public void backtrack(String digits, int i, String[] keypad, StringBuilder temp, List<String> res) {
        if (temp.length() == digits.length()) {
            res.add(temp.toString());
        }

        if (i < digits.length()) {
            int idx = digits.charAt(i) - '0';
            char[] alpha = keypad[idx].toCharArray();
            for (Character c : alpha) {
                temp.append(c);
                backtrack(digits, i + 1, keypad, temp, res);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }
}
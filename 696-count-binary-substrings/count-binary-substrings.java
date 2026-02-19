class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0)
                continue;
            if (s.charAt(i - 1) == s.charAt(i))
                continue;
            int j = i - 1;
            int p = i;
            while (j >= 0 && p < s.length()) {
                if (p - j + 1 == 2) {
                    count++;

                } else if (s.charAt(j) == s.charAt(j + 1) && s.charAt(p) == s.charAt(p - 1)) {
                    count++;

                }else{
                    break;
                }
                j--;
                p++;
            }
        }
        return count;
    }
}
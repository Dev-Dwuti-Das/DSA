class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int[] freq_p = new int[26];
    int[] freq_s = new int[26];
    List<Integer> res = new ArrayList<>();

    if(p.length() > s.length()) return new ArrayList<>();

    for (char c : p.toCharArray()) {
      freq_p[c - 'a']++;
    }
    int right = 0;
    int left = 0;

    while (right < s.length()) {
      while (right - left + 1 <= p.length()) {
        freq_s[s.charAt(right) - 'a']++;
        right++;
      }
      if (Arrays.equals(freq_p, freq_s)) {
        res.add(left);
      }
      freq_s[s.charAt(left) - 'a']--;
      left++;
    }

    return res;
  }
}
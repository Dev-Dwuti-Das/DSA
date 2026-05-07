class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] freq = new int[26];
    String b = "balloon";
    int count = 0;

    for (char x : text.toCharArray()) {
      freq[x - 'a']++;
    }

    boolean flag = true;
    while (flag) {
      count++;
      for (char c : b.toCharArray()) {
        freq[c - 'a']--;
        if (freq[c - 'a'] < 0) {
          flag = false;
          break;
        }
      }
    }
    return count-1;
  }
}
class Solution {
  public String convert(String s, int num) {
    if (num == 1)
      return s; // ✅ ADD THIS

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num; i++) {
      int m = i;
      while (m < s.length()) {
        sb.append(s.charAt(m));
        if (i == 0 || i == num - 1) {
          m += (2 * num - 2);
          continue;
        }
        int temp_front = (2 * num - 2) - 2 * i;
        if (m + temp_front < s.length()) {
          sb.append(s.charAt(m + temp_front));
        }

        m += (2 * num - 2);
      }
    }
    return sb.toString();
  }
}
class Solution {

  public int func(int num) {
    int ans = 1;
    while (num > 0) {
      int r = num % 10;
      ans *= r;
      num /= 10;
    }

    return ans;
  }

  public int smallestNumber(int n, int t) {

    for (int i = n;i <= 100;i++) {
      int mul = func(i);
      if (mul % t == 0) return i;
    }

    return -1;
  }
}
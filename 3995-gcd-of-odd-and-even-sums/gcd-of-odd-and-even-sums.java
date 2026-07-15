class Solution {
  public int gcdOfOddEvenSums(int n) {
    int odd_sum = 0;
    int even_sum = 0;

    for (int i = 1; i <= 2 * n; i++) {
      if (i % 2 == 0) {
        even_sum += i;
      } else {
        odd_sum += i;
      }
    }

    return gcd(odd_sum, even_sum);

  }

  public int gcd(int a, int b) {
    while (b % a != 0) {
      int rem = b % a;
      b = a;
      a = rem;
    }
    return a;
  }
}
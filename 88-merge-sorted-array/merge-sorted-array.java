class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0;
    int k1 = 0;
    int p2 = 0;
    int[] temp = new int[m + n];
    while (p1 < m && p2 < n) {
      if (nums1[p1] < nums2[p2]) {
        temp[k1] = nums1[p1];
        k1++;
        p1++;
      } else {
        temp[k1] = nums2[p2];
        k1++;
        p2++;
      }
    }

    while (p2 < n) {
      temp[k1] = nums2[p2];
      k1++;
      p2++;
    }

    while (p1 < m) {
      temp[k1] = nums1[p1];
      k1++;
      p1++;
    }

    for (int i = 0; i < m + n; i++) {
      nums1[i] = temp[i];
    }
  }
}
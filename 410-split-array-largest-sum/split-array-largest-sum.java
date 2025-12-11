class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int x : nums) {
            min = Math.max(min, x); 
            max += x;
        }
        int res = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (ok(nums, mid, k)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    public boolean ok(int[] nums, int mid, int k) {
        int currsum = 0;
        int count = 1;
        for (Integer x : nums) {
            currsum += x;
            if (currsum > mid) {
                count++;
                if (count > k)
                    return false;
                currsum = x;
            }
        }
        return true;
    }
}
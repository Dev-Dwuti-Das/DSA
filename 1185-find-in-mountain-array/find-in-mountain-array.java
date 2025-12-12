/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int min = 1;
        int max = mountainArr.length() - 1;
        int max2 = max;
        int peak = 0;
        int min1 = 0;
        boolean flag = false;
        int res = -1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int val = mountainArr.get(mid);
            int valprev = mountainArr.get(mid - 1);
            int valforward = mountainArr.get(mid + 1);

            if (valprev < val && val > valforward) {
                peak = mid;
                break;
            }
            if (valprev < val && val < valforward) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        while (min1 <= peak) {
            int mid1 = min1 + (peak - min1) / 2;
            int val = mountainArr.get(mid1);

            if (val == target) {
                flag = true;
                res = mid1;
                return mid1;
            }

            if (val < target) {
                min1 = mid1 + 1;
            } else {
                peak = mid1 - 1;
            }
        }

        if (!flag) {
            while (peak <= max2) {
                int mid2 = peak + (max2 - peak) / 2;
                int val = mountainArr.get(mid2);

                if (val == target) {
                    res = mid2;
                    return mid2;
                }

                if (val > target) {
                    peak = mid2 + 1;
                } else {
                    max2 = mid2 - 1;
                }
            }
        }
        return res;
    }
}
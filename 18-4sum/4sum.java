class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int p1 = 0; p1 < n - 3; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) continue;

            for (int p2 = n - 1; p2 > p1 + 2; p2--) {
                if (p2 < n - 1 && nums[p2] == nums[p2 + 1]) continue;

                int l = p1 + 1;
                int r = p2 - 1;

                while (l < r) {
                    long sum = (long) nums[p1] + nums[l] + nums[r] + nums[p2];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[p1], nums[l], nums[r], nums[p2]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}

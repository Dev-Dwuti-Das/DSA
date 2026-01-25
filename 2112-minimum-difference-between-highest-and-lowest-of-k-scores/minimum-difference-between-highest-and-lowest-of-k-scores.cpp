class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int diff =0;
        int ans =INT_MAX;
        int n = nums.size();

        if(k<=1)return 0;

        for(int i=0; i<=n-k; i++){
          diff= nums[i+k-1] - nums[i];
          ans= min(diff,ans);
        }

        return ans;
    }
};
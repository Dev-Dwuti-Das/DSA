class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n = len1+len2; 
        if(len1 > len2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = len1;

        while(left <= right){ 
            int mid1 = (right+left)/2;
            int mid2 = (n+1)/2 - mid1;

            int leftmax1 = (mid1 == 0)? Integer.MIN_VALUE : nums1[mid1-1];
            int leftmax2 = (mid2 == 0)? Integer.MIN_VALUE : nums2[mid2-1];
            int rightmin1 = (mid1 == len1)? Integer.MAX_VALUE :nums1[mid1];
            int rightmin2 = (mid2 == len2)? Integer.MAX_VALUE :nums2[mid2];

            if(leftmax1 <= rightmin2 && leftmax2 <= rightmin1){
                if(n%2 == 0){
                    return (Math.max(leftmax1, leftmax2)+Math.min(rightmin1, rightmin2))/2.0;
                }
                else{
                    return (double)Math.max(leftmax1, leftmax2);
                }
            }else if(leftmax1 > rightmin2){
                right = mid1-1;
            }
            else{
                left = mid1+1;
            }
        }
        return 0.0; 
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int halfLen = (m + n + 1) / 2;
        
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = halfLen - i;
            
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Check if we have found the correct partition
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // If total length is odd, the median is the max of the left elements
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // If total length is even, the median is the average of the two middle elements
                return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } else if (nums1LeftMax > nums2RightMin) {
                high = i - 1; // Move left in nums1
            } else {
                low = i + 1;  // Move right in nums1
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");

    }
}
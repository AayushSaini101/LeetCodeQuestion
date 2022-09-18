class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int nl = nums1.length;
        int ml = nums2.length;

        int low = 0;
        int high = nl;

        while (low <= high) {
            int c1 = (low + high) / 2;
            int c2 = (ml+nl+1)/2 - c1;

            int l1 = c1 == 0 ? Integer.MIN_VALUE : nums1[c1 - 1];
            int l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[c2 - 1];

            int r1 = c1 == nl ? Integer.MAX_VALUE : nums1[c1];
            int r2 = c2 == ml ? Integer.MAX_VALUE : nums2[c2];

            if (Math.max(l1,l2)<= Math.min(r1,r2)) {
                if ((nl + ml) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

                else
                    return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = c1 - 1;
            } else {
                low = c1 + 1;
            }

        }
        return 0.0;
    }

}
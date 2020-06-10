package code.lists;

public class FindMedianSortedArraysBinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int half = (m + n + 1) / 2;
        int startM = 0;
        int endM = m;
        while(startM <= endM) {
            int mid1 = (startM + endM) / 2;
            int mid2 = half - mid1;

            if(mid2 != 0 && mid1 != m && nums2[mid2-1] > nums1[mid1]) {
                startM = mid1 + 1;
            } else if( mid1 != 0 && mid2 != nums2.length && nums1[mid1 - 1] > nums2[mid2]) {
                endM = mid1 - 1;
            } else {
                // find the pos
                int maxLeft = 0;
                if(mid1 == 0) {
                    maxLeft = nums2[mid2 - 1];
                } else if (mid2 == 0) {
                    maxLeft = nums1[mid1 - 1];
                } else {
                    maxLeft = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                }

                if((m+n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if(mid1 == m) {
                    minRight = nums2[mid2];
                } else if(mid2 == n) {
                    minRight = nums1[mid1];
                } else {
                    minRight = Math.min(nums1[mid1], nums2[mid2]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        // int[] nums1 = new int[]{1,2,4,7,9,10};
        int[] nums1 = new int[]{2};
        // int[] nums2 = new int[]{0,3,4,5,6,7,8};
        int[] nums2 = new int[0];

        FindMedianSortedArraysBinarySearch findMedianSortedArrays = new FindMedianSortedArraysBinarySearch();
        double ret = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}

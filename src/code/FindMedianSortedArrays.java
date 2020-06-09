package code;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) {
            return findMid(nums2);
        }
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] combine = new int[nums1Len + nums2Len];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(p1 < nums1Len && p2 < nums2Len) {
            if(nums1[p1] <= nums2[p2]) {
                combine[index++] = nums1[p1];
                p1++;
            } else {
                combine[index++] = nums2[p2];
                p2++;
            }
        }
        while(p1 < nums1Len) {
            combine[index++] = nums1[p1++];
        }
        while(p2 < nums2Len) {
            combine[index++] = nums2[p2++];
        }

        return findMid(combine);
    }

    private double findMid(int[] array) {
        if(array == null || array.length == 0) {
            return 0.0;
        }
        if(array.length % 2 != 0) {
            return array[array.length/2];
        } else {
            return (array[array.length/2 - 1] + array[array.length/2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,7,9,10};
        int[] nums2 = new int[]{0,3,4,5,6,7,8};

        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double ret = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}

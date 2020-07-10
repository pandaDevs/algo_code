package code.HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; ++i) {
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; ++i) {
            set2.add(nums2[i]);
        }

        return setIntersection(set1, set2);
    }

    public int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size() > set2.size()) {
            return setIntersection(set2, set1);
        }

        int[] ret = new int[set1.size()];
        int idx = 0;
        for(Integer i : set1) {
            if(set2.contains(i)) {
                ret[idx++] = i;
            }
        }

        return Arrays.copyOf(ret, idx);
    }
}

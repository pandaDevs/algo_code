package code.HashTable;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null) {
            return false;
        }
        Set<Integer> windowSet = new HashSet<>();
        for(int i = 0; i <= k && i < nums.length; ++i) {
            if(!windowSet.add(nums[i])) {
                return true;
            }
        }
        for(int i = 1; i < nums.length - k; ++i) {
            windowSet.remove(nums[i - 1]);
            if(!windowSet.add(nums[i+k])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        ContainsNearbyDuplicate dup = new ContainsNearbyDuplicate();
        boolean ret = dup.containsNearbyDuplicate(nums, 2);
        System.out.println(ret);
    }
}

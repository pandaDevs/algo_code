package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        TwoSum twoSum = new TwoSum();
        int[] ret = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(ret));
    }
}

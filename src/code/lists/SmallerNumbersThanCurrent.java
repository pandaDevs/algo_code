package code.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        for(int i = 0; i < nums.length; ++i) {
            nums[i] = list.indexOf(nums[i]);
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] ret = new int[10];
        System.out.println(Arrays.toString(ret));
    }
}

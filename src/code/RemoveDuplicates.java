package code;

import java.util.Arrays;


public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                continue;
            }
            nums[len++] = nums[i];
        }
        return len;
    }
    public static void main(String[] args) {
        // int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] input = new int[] {1,1};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int len = removeDuplicates.removeDuplicates(input);
        System.out.println(len);
        System.out.println(Arrays.toString(input));
    }
}

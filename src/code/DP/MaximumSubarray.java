package code.DP;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,2,-5,4};
        MaximumSubarray dc = new MaximumSubarray();
        System.out.println(dc.maxSubArray(nums));
    }
}

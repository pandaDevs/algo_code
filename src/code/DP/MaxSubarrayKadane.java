package code.DP;

public class MaxSubarrayKadane {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int maxEndingHere = nums[0];
        int maxSubSum = nums[0];
        for(int i = 0; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSubSum = Math.max(maxEndingHere, maxSubSum);
        }

        return maxSubSum;
    }
}

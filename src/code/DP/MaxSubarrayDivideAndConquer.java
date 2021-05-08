package code.DP;

public class MaxSubarrayDivideAndConquer {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int middle = (left + right) / 2;
        int leftAns = maxSubArray(nums, left, middle);
        int rightAns = maxSubArray(nums, middle + 1, right);
        int leftMax = nums[middle];
        int rightMax = nums[middle + 1];
        int tmp = 0;
        for(int i = middle; i >= left; --i) {
            tmp += nums[i];
            if(tmp > leftMax) leftMax = tmp;
        }

        tmp = 0;
        for(int i = middle + 1; i <= right; ++i) {
            tmp += nums[i];
            if(tmp > rightMax) rightMax = tmp;
        }

        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,2,-5,4};
        MaxSubarrayDivideAndConquer dc = new MaxSubarrayDivideAndConquer();
        System.out.println(dc.maxSubArray(nums));
    }
}

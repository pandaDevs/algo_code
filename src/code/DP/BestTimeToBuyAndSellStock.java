package code.DP;

import java.util.regex.Pattern;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] gap = new int[length - 1];
        for(int i = 0; i < length - 1; ++i) {
            gap[i] = prices[i + 1] - prices[i];
        }
        return maxSubArray(gap);
    }
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
        String namePattern = "[\\w-]+";
        String expName = "aaddb-112";
        System.out.println(Pattern.matches(namePattern, expName));
    }
}

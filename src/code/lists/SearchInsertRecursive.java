package code.lists;

public class SearchInsertRecursive {
    public int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        return findPos(nums, 0, nums.length - 1, target);
    }

    private int findPos(int[] nums, int start, int end, int target) {
        if(start < end ) {
            int midIndex = (start + end) >> 1;
            if(nums[midIndex] == target) {
                return midIndex;
            }
            if(nums[midIndex] < target) {
                return findPos(nums, midIndex + 1, end, target);
            } else {
                return findPos(nums, start, midIndex -1, target);
            }

        }

        return nums[start] >= target ? start : start + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        SearchInsertRecursive searchInsert = new SearchInsertRecursive();
        int ret = searchInsert.searchInsert(input, 0);
        System.out.println(ret);
    }
}

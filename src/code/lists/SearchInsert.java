package code.lists;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        if(target <= nums[start]) {
            return 0;
        }
        if(target > nums[end]) {
            return nums.length;
        }

        while(start != end - 1) {
            if(target == nums[end]) {
                return end;
            }
            if(target == nums[start]) {
                return start;
            }
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        SearchInsert searchInsert = new SearchInsert();
        int ret = searchInsert.searchInsert(input, 0);
        System.out.println(ret);
    }
}

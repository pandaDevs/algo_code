package code.lists;

public class FindNumbers {
    public int findNumbers(int[] nums) {
        int[] division = new int[]{10,1000,100000};
        int count = 0;
        for (int num : nums) {
            for (int i : division) {
                int ret = num / i;
                if (ret >= 1 && ret < 10) {
                    ++count;
                    break;
                }

                if (ret == 0) {
                    break;
                }
            }
        }

        return count;
    }
}

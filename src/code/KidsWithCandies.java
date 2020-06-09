package code;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = maxNumInArray(candies);
        List<Boolean> distribute = new ArrayList<>(128);
        for (int candy : candies) {
            distribute.add((candy + extraCandies >= max));
        }
        return distribute;
    }

    private int maxNumInArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

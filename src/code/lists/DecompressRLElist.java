package code.lists;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i+=2) {
            int repeated = nums[i];
            for(int j = 0; j < repeated; ++j) {
                list.add(nums[i + 1]);
            }
        }

        int size = list.size();
        int[] ret = new int[size];
        for(int i = 0; i < ret.length; ++i) {
            ret[i] = list.get(i);
        }

        return ret;
    }
}

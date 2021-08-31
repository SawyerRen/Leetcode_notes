package topics.array;

import java.util.ArrayList;
import java.util.List;

public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = nums[i] % len;
            if (index == len) index = 0;
            nums[index] += len;
        }
        if (2 * len < nums[0] && nums[0] <= 3 * len) res.add(len);
        for (int i = 1; i < len; i++) {
            if (2 * len < nums[i] && nums[i] <= 3 * len) res.add(i);
        }
        return res;
    }
}

package all_solution.q300;

import java.util.ArrayList;
import java.util.List;

public class Q229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer major1 = null, major2 = null;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (major1 != null && num == major1) {
                count1++;
            } else if (major2 != null && num == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = num;
                count1++;
            } else if (count2 == 0) {
                major2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == major1) count1++;
            if (major2 != null && num == major2) count2++;
        }
        if (count1 > nums.length / 3) res.add(major1);
        if (count2 > nums.length / 3) res.add(major2);
        return res;
    }
}

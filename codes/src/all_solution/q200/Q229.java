package all_solution.q200;

import java.util.*;

public class Q229 {
    public List<Integer> majorityElement(int[] nums) {
        Integer res1 = null, res2 = null;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (res1 != null && num == res1) {
                count1++;
            } else if (res2 != null && num == res2) {
                count2++;
            } else if (count1 == 0) {
                res1 = num;
                count1++;
            } else if (count2 == 0) {
                res2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (res1 != null && num == res1) count1++;
            else if (res2 != null && num == res2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(res1);
        if (count2 > nums.length / 3) res.add(res2);
        return res;
    }
}

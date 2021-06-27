package topics.array;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

 */
public class Q163 {
    public List<String> findMissingRanges(int[] a, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (a.length == 0) {
            add2List(res, lower, upper);
            return res;
        }
        if (lower < a[0]) {
            add2List(res, lower, a[0] - 1);
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] > 1) {
                add2List(res, a[i - 1] + 1, a[i] - 1);
            }
        }
        if (upper > a[a.length - 1]) {
            add2List(res, a[a.length - 1] + 1, upper);
        }
        return res;
    }

    private void add2List(List<String> res, int lower, int upper) {
        if (lower == upper) {
            res.add(String.valueOf(lower));
        } else {
            res.add(lower + "->" + upper);
        }
    }
}

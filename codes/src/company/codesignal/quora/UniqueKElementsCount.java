package company.codesignal.quora;

import java.util.HashSet;
import java.util.Set;

public class UniqueKElementsCount {
    static int solution(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        int res = 0;
        while (j < nums.length) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            if (set.size() >= k) res++;
            j++;
        }
        return res;
    }
}

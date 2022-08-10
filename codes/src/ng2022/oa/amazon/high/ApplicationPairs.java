package ng2022.oa.amazon.high;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApplicationPairs {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        a.sort(Comparator.comparingInt(i -> i[1]));
        b.sort(Comparator.comparingInt(i -> i[1]));
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                --j;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    }
}

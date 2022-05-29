package all_solution.q2100;

import java.util.ArrayList;
import java.util.List;

public class Q2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return new ArrayList<>();
        long num = 2;
        List<Long> res = new ArrayList<>();
        while (finalSum >= num) {
            res.add(num);
            finalSum -= num;
            num += 2;
        }
        res.add(finalSum + res.remove(res.size() - 1));
        return res;
    }
}

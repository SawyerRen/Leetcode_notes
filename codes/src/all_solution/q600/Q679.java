package all_solution.q600;

import java.util.ArrayList;
import java.util.List;

public class Q679 {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < 0.001;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (Double c : compute(list, i, j)) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == i || k == j) continue;
                        nextRound.add(list.get(k));
                    }
                    if (helper(nextRound)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> compute(List<Double> list, int i, int j) {
        List<Double> res = new ArrayList<>();
        double a = list.get(i), b = list.get(j);
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }
}

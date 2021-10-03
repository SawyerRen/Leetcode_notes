package company.bytedance.oa2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChanceToGet24 {
    static String calculateProb(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        if (list.size() == 4) {
            return helper(list) ? "1" : "0";
        }
        int[] count = new int[11];
        Arrays.fill(count, 4);
        for (int card : cards) {
            count[card]--;
        }
        int total = 0;
        int validCount = 0;
        for (int i = 1; i <= 10; i++) {
            total += count[i];
            list.add((double) i);
            if (helper(list)) validCount += count[i];
            list.remove(list.size() - 1);
        }
        return validCount + "/" + total;
    }

    static private boolean helper(List<Double> list) {
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

    static private List<Double> compute(List<Double> list, int i, int j) {
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

    public static void main(String[] args) {
        System.out.println(calculateProb(new int[]{1, 2, 3, 4}));
        System.out.println(calculateProb(new int[]{1, 1, 1, 1}));
        System.out.println(calculateProb(new int[]{1, 2, 3}));
    }
}

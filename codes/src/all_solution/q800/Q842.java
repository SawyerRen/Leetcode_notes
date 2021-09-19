package all_solution.q800;

import java.util.ArrayList;
import java.util.List;

public class Q842 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        if (helper(res, num)) return res;
        return new ArrayList<>();
    }

    private boolean helper(List<Integer> res, String num) {
        if (res.size() > 2 && num.length() == 0) return true;
        for (int i = 0; i < num.length(); i++) {
            if (i > 0 && num.charAt(0) == '0') break;
            long n = Long.parseLong(num.substring(0, i + 1));
            if (n > Integer.MAX_VALUE) break;
            if (res.size() < 2 || n == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add((int) n);
                if (helper(res, num.substring(i + 1))) return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}

package company.fbfinal;

import java.util.ArrayList;
import java.util.List;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1) odd++;
        }
        List<String> res = new ArrayList<>();
        if (odd > 1) return res;
        Character center = null;
        if (odd == 1) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] % 2 == 1) {
                    center = (char) (i);
                    count[i]--;
                    break;
                }
            }
        }
        helper(res, count, center == null ? "" : String.valueOf(center), s.length());
        return res;
    }

    private void helper(List<String> res, int[] count, String s, int length) {
        if (s.length() == length) {
            res.add(new String(s));
            return;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count[i] -= 2;
                helper(res, count, (char) (i) + s + (char) (i), length);
                count[i] += 2;
            }
        }
    }
}

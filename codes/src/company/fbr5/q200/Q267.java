package company.fbr5.q200;

import java.util.ArrayList;
import java.util.List;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        List<String> res = new ArrayList<>();
        int odd = 0;
        for (int i : count) {
            if (i % 2 != 0) {
                odd++;
            }
        }
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
        helper(res, center == null ? "" : String.valueOf(center), count, s.length());
        return res;
    }

    private void helper(List<String> res, String s, int[] count, int length) {
        if (s.length() == length) {
            res.add(new String(s));
            return;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count[i] -= 2;
                helper(res, (char) (i) + s + (char) (i), count, length);
                count[i] += 2;
            }
        }
    }
}

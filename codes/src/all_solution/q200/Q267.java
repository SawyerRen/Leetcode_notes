package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean odd = false;
        char center = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                if (odd) return res;
                center = (char) (i + 'a');
                count[i]--;
                odd = true;
            }
        }
        helper(res, center == ' ' ? "" : String.valueOf(center), count, s.length());
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
                char c = (char) (i + 'a');
                helper(res, c + s + c, count, length);
                count[i] += 2;
            }
        }
    }
}

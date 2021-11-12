package company.fb2;

import java.util.Arrays;
import java.util.TreeSet;

public class Q681 {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(res[0], res[1], res[3], res[4]));
        res[4] = next(set, res[4], '9');
        if (time.charAt(4) < res[4]) return new String(res);

        res[3] = next(set, res[3], '5');
        if (time.charAt(3) < res[3]) return new String(res);
        res[1] = next(set, res[1], res[0] == '2' ? '3' : '9');
        if (time.charAt(1) < res[1]) return new String(res);
        res[0] = next(set, res[0], '2');
        return new String(res);
    }

    private char next(TreeSet<Character> set, char c, char limit) {
        Character n = set.higher(c);
        if (n == null || n > limit) return set.first();
        return n;
    }
}

package company.fbr4.q600;

import java.util.Arrays;
import java.util.TreeSet;

public class Q681 {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(res[0], res[1], res[3], res[4]));

        res[4] = findNext(set, res[4], '9');
        if (res[4] > time.charAt(4)) return new String(res);
        res[3] = findNext(set, res[3], '5');
        if (res[3] > time.charAt(3)) return new String(res);

        res[1] = findNext(set, res[1], res[0] == '2' ? '3' : '9');
        if (res[1] > time.charAt(1)) return new String(res);
        res[0] = findNext(set, res[0], '2');
        return new String(res);
    }

    private char findNext(TreeSet<Character> set, char c, char limit) {
        Character higher = set.higher(c);
        if (higher == null || higher > limit) return set.first();
        return higher;
    }
}

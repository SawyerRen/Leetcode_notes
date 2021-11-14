package company.fbfinal;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Q681 {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(res[0], res[1], res[3], res[4]));
        res[4] = getNext(res[4], set, '9');
        if (res[4] > time.charAt(4)) return new String(res);
        res[3] = getNext(res[3], set, '5');
        if (res[3] > time.charAt(3)) return new String(res);
        res[1] = getNext(res[1], set, res[0] == '2' ? '3' : '9');
        if (res[1] > time.charAt(1)) return new String(res);
        res[0] = getNext(res[0], set, '2');
        return new String(res);
    }

    private char getNext(char c, TreeSet<Character> set, char limit) {
        Character higher = set.higher(c);
        if (higher != null && higher <= limit) return higher;
        return set.first();
    }
}

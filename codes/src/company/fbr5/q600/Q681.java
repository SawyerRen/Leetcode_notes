package company.fbr5.q600;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;

public class Q681 {
    public String nextClosestTime(String time) {
        char[] chars = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(chars[0], chars[1], chars[3], chars[4]));
        chars[4] = nextTime(chars[4], set, '9');
        if (chars[4] > time.charAt(4)) return new String(chars);
        chars[3] = nextTime(chars[3], set, '5');
        if (chars[3] > time.charAt(3)) return new String(chars);
        chars[1] = nextTime(chars[1], set, chars[0] == '2' ? '3' : '9');
        if (chars[1] > time.charAt(1)) return new String(chars);
        chars[0] = nextTime(chars[0], set, '2');
        return new String(chars);
    }

    private char nextTime(char c, TreeSet<Character> set, char limit) {
        Character next = set.higher(c);
        if (next != null && next <= limit) return next;
        return set.first();
    }
}

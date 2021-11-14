package company.fbr5.again;

import java.util.Arrays;
import java.util.TreeSet;

public class Q681 {
    public String nextClosestTime(String time) {
        char[] chars = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>();
        set.addAll(Arrays.asList(chars[0], chars[1], chars[3], chars[4]));
        chars[4] = getNext(set, chars[4], '9');
        if (chars[4] > time.charAt(4)) return new String(chars);
        chars[3] = getNext(set, chars[3], '5');
        if (chars[3] > time.charAt(3)) return new String(chars);
        chars[1] = getNext(set, chars[1], chars[0] == '2' ? '3' : '9');
        if (chars[1] > time.charAt(1)) return new String(chars);
        chars[0] = getNext(set, chars[0], '2');
        return new String(chars);
    }

    private char getNext(TreeSet<Character> set, char c, char limit) {
        Character next = set.higher(c);
        if (next != null && next <= limit) return next;
        return set.first();
    }
}

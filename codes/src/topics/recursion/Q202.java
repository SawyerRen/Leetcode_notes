package topics.recursion;

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        int num = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            num += Math.pow(c - '0', 2);
        }
        if (seen.contains(num)) return false;
        seen.add(num);
        return isHappy(num);
    }
}

package frequency.q200;

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    Set<Integer> visited = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (visited.contains(n)) return false;
        visited.add(n);
        int num = 0;
        while (n != 0) {
            int tail = n % 10;
            num += tail * tail;
            n /= 10;
        }
        return isHappy(num);
    }
}

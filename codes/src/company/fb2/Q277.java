package company.fb2;

public class Q277 {
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) res = i;
        }
        for (int i = 0; i < n; i++) {
            if (res == i) continue;
            if (knows(res, i) || !knows(i, res)) return -1;
        }
        return res;
    }

    boolean knows(int a, int b) {
        return true;
    }
}

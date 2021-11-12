package company.fbr5.q200;

public class Q277 {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) celebrity = i;
        }
        for (int i = 0; i < n; i++) {
            if (celebrity == i) continue;
            if (knows(celebrity, i) || !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }

    boolean knows(int a, int b) {
        return true;
    }
}

package company.fbr4.q200;

public class Q277 {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) celebrity = i;
        }
        for (int i = 0; i < n; i++) {
            if (celebrity == i) continue;
            if (!knows(i, celebrity) || knows(celebrity, i)) return -1;
        }
        return celebrity;
    }

    boolean knows(int a, int b) {
        return true;
    }
}

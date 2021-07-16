package topics.greedy;

public class Q277 {
    public int findCelebrity(int n) {
        // 先假设名人是0
        int celebrity = 0;
        // 如果遍历到名人认识的数，更新名人为i
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        // 检查这个名人是不是符合条件
        for (int i = 0; i < n; i++) {
            if (celebrity == i) continue;
            if (knows(celebrity, i) || !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}

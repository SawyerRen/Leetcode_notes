package all_solution.q0;

public class Q70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre1 = 2, pre2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}

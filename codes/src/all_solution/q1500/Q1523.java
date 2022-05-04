package all_solution.q1500;

public class Q1523 {
    public int countOdds(int low, int high) {
        int len = high - low + 1;
        if (len % 2 == 0) return len / 2;
        if (low % 2 == 0) return len / 2;
        return len / 2 + 1;
    }
}

package all_solution.q100;

public class Q171 {
    public int titleToNumber(String columnTitle) {
        long res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + c - 'A' + 1;
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}

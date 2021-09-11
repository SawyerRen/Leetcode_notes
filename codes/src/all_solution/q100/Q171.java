package all_solution.q100;

public class Q171 {
    public int titleToNumber(String columnTitle) {
        long res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + num;
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}

package all_solution.q1500;

public class Q1573 {
    public int numWays(String s) {
        int mod = (int) 1e9 + 7;
        long ones = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        if (ones == 0) return (int)((n - 1) * (n - 2) / 2 % mod);
        if (ones % 3 != 0) return 0;
        long count = 0, firstCut = 0, thirdCut = 0;
        long partTarget = ones / 3;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') count++;
            if (count == partTarget) {
                firstCut++;
            } else if (count == partTarget * 2) {
                thirdCut++;
            }
        }
        return (int) (firstCut * thirdCut % mod);
    }
}

package all_solution.q100;

public class Q132 {
    public int minCut(String s) {
        return helper(s, 0, s.length() - 1, s.length() - 1);
    }

    private int helper(String s, int start, int end, int minCut) {
        if (start == end || isPal(s, start, end)) return 0;
        for (int i = start; i <= end; i++) {
            if (isPal(s, start, i)) {
                minCut = Math.min(minCut, 1 + helper(s, i + 1, end, minCut));
            }
        }
        return minCut;
    }

    private boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

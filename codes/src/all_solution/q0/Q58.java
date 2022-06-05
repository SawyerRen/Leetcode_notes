package all_solution.q0;

public class Q58 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && res == 0) continue;
            else if (s.charAt(i) == ' ') return res;
            res++;
        }
        return res;
    }
}

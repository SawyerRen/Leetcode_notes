package all_solution.q0;

public class Q58 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (res != 0) return res;
                else continue;
            }
            res++;
        }
        return res;
    }
}

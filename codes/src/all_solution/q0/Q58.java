package all_solution.q0;

public class Q58 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (res > 0 && chars[i] == ' ') break;
            if (chars[i] == ' ') continue;
            res++;
        }
        return res;
    }
}

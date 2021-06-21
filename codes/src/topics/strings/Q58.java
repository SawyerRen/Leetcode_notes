package topics.strings;

public class Q58 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean metWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') metWord = true;
            if (s.charAt(i) == ' ') {
                if (!metWord) continue;
                return res;
            }
            res++;
        }
        return res;
    }
}

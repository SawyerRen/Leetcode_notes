package all_solution.q200;

public class Q151 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            if (builder.length() == 0) {
                builder.append(s, j + 1, i + 1);
            } else {
                builder.append(" ").append(s, j + 1, i + 1);
            }
            i = j - 1;
        }
        return builder.toString();
    }
}

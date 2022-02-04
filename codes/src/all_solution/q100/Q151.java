package all_solution.q100;

public class Q151 {
    public String reverseWords(String s) {
        int right = s.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') right--;
            if (right < 0) break;
            int left = right - 1;
            while (left >= 0 && s.charAt(left) != ' ') left--;
            if (builder.length() == 0) {
                builder.append(s, left + 1, right + 1);
            } else {
                builder.append(" ").append(s, left + 1, right + 1);
            }
            right = left - 1;
        }
        return builder.toString();
    }
}

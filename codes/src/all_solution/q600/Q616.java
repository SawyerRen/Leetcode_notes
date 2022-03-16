package all_solution.q600;

public class Q616 {
    public String addBoldTag(String s, String[] words) {
        int end = 0;
        boolean[] bold = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            if (end > i) bold[i] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                builder.append(s.charAt(i));
            } else {
                builder.append("<b>");
                while (i < s.length() && bold[i]) {
                    builder.append(s.charAt(i++));
                }
                i--;
                builder.append("</b>");
            }
        }
        return builder.toString();
    }
}

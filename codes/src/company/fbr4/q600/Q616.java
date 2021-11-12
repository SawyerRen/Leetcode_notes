package company.fbr4.q600;

public class Q616 {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] bold = new boolean[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) builder.append(s.charAt(i));
            else {
                builder.append("<b>");
                while (i < s.length() && bold[i]) {
                    builder.append(s.charAt(i));
                    i++;
                }
                builder.append("</b>");
                i--;
            }
        }
        return builder.toString();
    }
}

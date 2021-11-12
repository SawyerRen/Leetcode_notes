package company.fbr5.q600;

public class Q616 {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) end = Math.max(end, i + word.length());
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
                i--;
                builder.append("</b>");
            }
        }
        return builder.toString();
    }
}

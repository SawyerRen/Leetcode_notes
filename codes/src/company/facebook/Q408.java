package company.facebook;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else if (Character.isDigit(c2)) {
                if (c2 == '0') return false;
                int length = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    length = length * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += length;
            } else {
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}

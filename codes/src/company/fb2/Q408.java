package company.fb2;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int count = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    count = count * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += count;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}

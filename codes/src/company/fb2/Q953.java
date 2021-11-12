package company.fb2;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (!valid(index, s1, s2)) return false;
        }
        return true;
    }

    private boolean valid(int[] index, String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return index[s1.charAt(i) - 'a'] < index[s2.charAt(j) - 'a'];
            }
            i++;
            j++;
        }
        return s1.length() <= s2.length();
    }
}

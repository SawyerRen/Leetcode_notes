package topics.two_pointer;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0, indexT = 0;
        while (indexS < s.length()) {
            if (indexT == t.length()) return false;
            if (s.charAt(indexS) == t.charAt(indexT)) indexS++;
            indexT++;
        }
        return true;
    }
}

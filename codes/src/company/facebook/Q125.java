package company.facebook;

public class Q125 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && (s1.charAt(i) == ' ' || !Character.isLetterOrDigit(s1.charAt(i)))) i++;
            while (i < j && (s1.charAt(j) == ' ' || !Character.isLetterOrDigit(s1.charAt(j)))) j--;
            if (s1.charAt(i) != s1.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

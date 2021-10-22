package company.facebook;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean foundOne = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                if (foundOne) return false;
                foundOne = true;
            }
        }
        return true;
    }
}

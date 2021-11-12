package company.fbr4.q200;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        boolean odd = false;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }
}

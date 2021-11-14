package company.fbfinal;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] % 2 == 1) {
                odd++;
            } else {
                odd--;
            }
        }
        return odd < 2;
    }
}

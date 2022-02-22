package all_solution.q200;

public class Q266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean odd = false;
        for (int v : count) {
            if (v % 2 != 0) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }
}

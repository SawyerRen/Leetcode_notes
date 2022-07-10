package ng2022.q400;

public class Q409 {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int pairCount = 0;
        boolean odd = false;
        for (int val : count) {
            if (val % 2 != 0) odd = true;
            pairCount += val / 2;
        }
        return odd ? pairCount * 2 + 1 : pairCount * 2;
    }
}

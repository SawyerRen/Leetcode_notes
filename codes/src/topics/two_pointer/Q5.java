package topics.two_pointer;

public class Q5 {
    int left, right;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            findPartMaxLen(s, i, i);
            findPartMaxLen(s, i, i + 1);
        }
        return s.substring(left, right);
    }

    private void findPartMaxLen(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        int curLen = j - i - 1;
        if (curLen > maxLen) {
            maxLen = curLen;
            left = i + 1;
            right = j;
        }
    }
}

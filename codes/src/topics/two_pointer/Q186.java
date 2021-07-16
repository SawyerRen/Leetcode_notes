package topics.two_pointer;

public class Q186 {
    public void reverseWords(char[] s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                reverse(s, left, right);
                left = i + 1;
                right = i + 1;
            } else {
                right = i;
            }
        }
        reverse(s, left, right);
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

package all_solution.q500;

public class Q557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (j < chars.length && chars[j] != ' ') j++;
            reverse(chars, i, j - 1);
            i = j + 1;
            j += 1;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }
}

package all_solution.q500;

public class Q556 {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int k = chars.length - 2;
        while (k >= 0 && chars[k] >= chars[k + 1]) {
            k--;
        }
        if (k < 0) return -1;
        int r = chars.length - 1;
        while (chars[r] <= chars[k]) r--;
        swap(chars, k, r);
        reverse(chars, k + 1, chars.length - 1);
        long res = Long.parseLong(new String(chars));
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int k, int r) {
        char c = chars[k];
        chars[k] = chars[r];
        chars[r] = c;
    }
}

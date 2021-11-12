package company.fb2;

public class Q556 {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int k = chars.length - 2;
        while (k >= 0 && chars[k] >= chars[k + 1]) k--;
        if (k < 0) return -1;
        int r = chars.length - 1;
        while (chars[k] >= chars[r]) r--;
        swap(chars, k, r);
        k++;
        r = chars.length - 1;
        while (k < r) {
            swap(chars, k, r);
            k++;
            r--;
        }
        return Integer.parseInt(new String(chars));
    }

    private void swap(char[] chars, int k, int r) {
        char c = chars[k];
        chars[k] = chars[r];
        chars[r] = c;
    }
}

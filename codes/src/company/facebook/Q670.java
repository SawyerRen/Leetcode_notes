package company.facebook;

public class Q670 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int[] index = new int[10];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 9; j > s.charAt(i) - '0'; j--) {
                if (index[j] > i) {
                    return swap(s, i, index[j]);
                }
            }
        }
        return num;
    }

    private int swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return Integer.parseInt(new String(chars));
    }
}

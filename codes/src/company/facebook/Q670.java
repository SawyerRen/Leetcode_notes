package company.facebook;

public class Q670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < chars.length; i++) {
            index[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int k = 9; k > chars[i] - '0'; k--) {
                if (index[k] > i) {
                    char c = chars[index[k]];
                    chars[index[k]] = chars[i];
                    chars[i] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}

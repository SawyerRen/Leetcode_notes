package company.fbr4.q600;

public class Q670 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int[] index = new int[10];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int n = 9; n > s.charAt(i) - '0'; n--) {
                if (index[n] > i) {
                    char[] chars = s.toCharArray();
                    char c = chars[i];
                    chars[i] = chars[index[n]];
                    chars[index[n]] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}

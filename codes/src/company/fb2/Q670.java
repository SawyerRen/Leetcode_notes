package company.fb2;

public class Q670 {
    public int maximumSwap(int num) {
        int[] index = new int[10];
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 9; j > s.charAt(i) - '0'; j--) {
                if (index[j] > i) {
                    char[] chars = s.toCharArray();
                    char c = chars[i];
                    chars[i] = chars[index[j]];
                    chars[index[j]] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}

package company.facebook.freq;

public class Q670 {
    public int maximumSwap(int num) {
        int[] index = new int[10];
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int val = 9; val > s.charAt(i) - '0'; val--) {
                if (index[val] > i) {
                    char[] chars = s.toCharArray();
                    char c = chars[i];
                    chars[i] = chars[index[val]];
                    chars[index[val]] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}

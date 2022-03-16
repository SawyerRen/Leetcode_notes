package all_solution.q600;

public class Q670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < chars.length; i++) {
            index[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                int idx = index[j];
                if (idx > i) {
                    char c = chars[i];
                    chars[i] = chars[idx];
                    chars[idx] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}

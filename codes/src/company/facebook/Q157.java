package company.facebook;

public class Q157 {
    public int read(char[] buf, int n) {
        int total = 0;
        char[] temp = new char[4];
        while (total < n) {
            int len = read4(temp);
            if (total + len >= n) {
                len = n - total;
            }
            for (int i = 0; i < len; i++) {
                buf[total++] = temp[i];
            }
            if (len < 4) break;
        }
        return total;
    }

    int read4(char[] buf4) {
        return 4;
    }
}

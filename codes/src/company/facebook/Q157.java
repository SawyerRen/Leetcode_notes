package company.facebook;

public class Q157 {
    public int read(char[] buf, int n) {
        int totalLength = 0;
        char[] buf4 = new char[4];
        while (totalLength < n ) {
            int readLength = read4(buf4);
            if (totalLength + readLength > n) {
                readLength = n - totalLength;
            }
            for (int i = 0; i < readLength; i++) {
                buf[totalLength++] = buf4[i];
            }
            if (readLength < 4) break;
        }
        return totalLength;
    }

    int read4(char[] buf4) {
        return 4;
    }
}

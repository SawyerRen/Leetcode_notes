package company.fbr4.again;

public class Q157 {
    public int read(char[] buf, int n) {
        int ptr = 0;
        char[] buff = new char[4];
        while (ptr < n) {
            int count = read4(buff);
            if (ptr + count >= n) count = n - ptr;
            for (int i = 0; i < count; i++) {
                buf[ptr++] = buff[i];
            }
            if (count < 4) break;
        }
        return ptr;
    }

    int read4(char[] buf4) {
        return 4;
    }
}

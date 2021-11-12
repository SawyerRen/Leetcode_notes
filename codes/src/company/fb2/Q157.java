package company.fb2;

public class Q157 {
    public int read(char[] buf, int n) {
        char[] buff = new char[4];
        int pointer = 0;
        while (pointer < n) {
            int count = read4(buff);
            if (pointer + count >= n) {
                count = n - pointer;
            }
            for (int i = 0; i < count; i++) {
                buf[pointer++] = buff[i];
            }
            if (count < 4) break;
        }
        return pointer;
    }

    int read4(char[] buf4) {
        return 4;
    }
}

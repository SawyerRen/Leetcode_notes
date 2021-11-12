package company.fbr4.again;

public class Q158 {
    char[] buff = new char[4];
    int buffPtr = 0;
    int buffCount = 0;

    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCount = read4(buff);
            }
            while (ptr < n && buffPtr < buffCount) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr == buffCount) {
                buffPtr = 0;
            }
            if (buffCount < 4) break;
        }
        return ptr;
    }

    int read4(char[] buf4) {
        return 4;
    }
}

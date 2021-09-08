package topics.array;

public class Q157 {
    int read4(char[] buffer) {
        return 4;
    }

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int len = 0;
        while (len < n) {
            int size = read4(buffer);
            if (size == 0) break;
            System.arraycopy(buf, len, buffer, 0, size);
            len += size;
        }
        return len;
    }
}

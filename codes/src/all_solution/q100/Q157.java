package all_solution.q100;

public abstract class Q157 {
    public int read(char[] buf, int n) {
        int totalLength = 0;
        char[] temp = new char[4];
        while (totalLength < n) {
            int readLength = read4(temp);
            if (totalLength + readLength >= n) {
                readLength = n - totalLength;
            }
            for (int i = 0; i < readLength; i++) {
                buf[totalLength++] = temp[i];
            }
            if (readLength < 4) break;
        }
        return totalLength;
    }

    abstract int read4(char[] buf4);
}

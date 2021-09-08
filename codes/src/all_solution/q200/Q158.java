package all_solution.q200;

public abstract class Q158 {
    char[] preBuf = new char[4];
    int preIndex = 0;
    int preCount = 0;

    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (preIndex == 0) {
                preCount = read4(preBuf);
            }
            while (total < n && preIndex < preCount) {
                buf[total++] = preBuf[preIndex++];
            }
            if (preIndex == preCount) preIndex = 0;
            if (preCount == 0) break;
        }
        return total;
    }

    abstract int read4(char[] buf4);
}

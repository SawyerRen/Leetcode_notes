package all_solution.q100;

public abstract class Q157 {
    public int read(char[] buf, int n) {
        char[] chars = new char[4];
        int pointer = 0;
        while (pointer < n) {
            int len = read4(chars);
            for (int i = 0; i < len && pointer < n; i++) {
                buf[pointer++] = chars[i];
            }
            if (len < 4) break;
        }
        return pointer;
    }

    abstract int read4(char[] buf4);
}

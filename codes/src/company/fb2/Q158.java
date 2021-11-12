package company.fb2;

public class Q158 {
    public class Solution {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        char[] buff = new char[4];
        int buffPointer = 0;
        int buffCount = 0;

        public int read(char[] buf, int n) {
            int pointer = 0;
            while (pointer < n) {
                if (buffPointer == 0) {
                    buffCount = read4(buff);
                }
                while (pointer < n && buffPointer < buffCount) {
                    buf[pointer++] = buff[buffPointer++];
                }
                if (buffPointer == buffCount) buffPointer = 0;
                if (buffCount < 4) break;
            }
            return pointer;
        }

        int read4(char[] buf4) {
            return 4;
        }
    }
}

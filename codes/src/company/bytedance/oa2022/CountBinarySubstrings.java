package company.bytedance.oa2022;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int preLen = 0;
        int curLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) res++;
        }
        return res;
    }
}

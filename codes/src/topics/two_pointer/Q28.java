package topics.two_pointer;

public class Q28 {
    public int strStr(String haystack, String needle) {
        int i = 0, j = needle.length() - 1;
        while (j < haystack.length()) {
            int index1 = i;
            int index2 = 0;
            while (index2 < needle.length() && haystack.charAt(index1) == needle.charAt(index2)) {
                index1++;
                index2++;
            }
            if (index2 == needle.length()) {
                return i;
            } else {
                i++;
                j++;
            }
        }
        return -1;
    }
}

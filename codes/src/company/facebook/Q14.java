package company.facebook;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}

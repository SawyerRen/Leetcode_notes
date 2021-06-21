package topics.recursion;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int i = 0;
        char num = pre.charAt(i);
        while (i < pre.length()) {
            while (i < pre.length() && pre.charAt(i) == num) {
                i++;
                count++;
            }
            builder.append(count).append(num);
            count = 0;
            if (i < pre.length()) {
                num = pre.charAt(num);
            }
        }
        return builder.toString();
    }
}

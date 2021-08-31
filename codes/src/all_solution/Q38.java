package all_solution;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        char c = pre.charAt(0);
        int count = 0;
        for (int i = 0; i < pre.length(); i++) {
            if (pre.charAt(i) == c) {
                count++;
            } else {
                builder.append(count).append(c);
                c = pre.charAt(i);
                count = 1;
            }
        }
        builder.append(count).append(c);
        return builder.toString();
    }
}

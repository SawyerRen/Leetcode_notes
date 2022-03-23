package all_solution.q900;

import java.util.HashSet;
import java.util.Set;

public class Q929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
            boolean add = false, at = false;
            for (char c : email.toCharArray()) {
                if (at) {
                    builder.append(c);
                    continue;
                }
                if (c == '.') continue;
                if (c == '+') {
                    add = true;
                    continue;
                } else if (c == '@') {
                    builder.append(c);
                    at = true;
                    continue;
                }
                if (!add) builder.append(c);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}

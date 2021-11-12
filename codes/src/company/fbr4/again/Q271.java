package company.fbr4.again;

import java.util.ArrayList;
import java.util.List;

public class Q271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (String str : strs) {
                builder.append(str.length()).append("/").append(str);
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int index = s.indexOf("/", i);
                int size = Integer.parseInt(s.substring(i, index));
                i = index + size + 1;
                res.add(s.substring(index + 1, i));
            }
            return res;
        }
    }
}

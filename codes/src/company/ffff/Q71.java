package company.ffff;

import java.util.LinkedList;

public class Q71 {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : path.split("/")) {
            if (list.size() > 0 && s.equals("..")) list.removeLast();
            else if (s.equals("..") || s.equals(".") || s.equals("")) continue;
            else list.addLast(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append("/").append(list.removeFirst());
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}

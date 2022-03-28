package all_solution.q1100;

import java.util.HashMap;
import java.util.Map;

public class Q1166 {
    class FileSystem {
        class Node {
            Map<String, Node> map = new HashMap<>();
            Integer value;
        }

        Node root;

        public FileSystem() {
            root = new Node();
            root.value = -1;
        }

        public boolean createPath(String path, int value) {
            String[] split = path.split("/");
            Node cur = root;
            for (int i = 1; i < split.length - 1; i++) {
                if (!cur.map.containsKey(split[i])) return false;
                cur = cur.map.get(split[i]);
            }
            if (cur.map.containsKey(split[split.length - 1])) return false;
            Node node = new Node();
            node.value = value;
            cur.map.put(split[split.length - 1], node);
            return true;
        }

        public int get(String path) {
            String[] split = path.split("/");
            Node cur = root;
            for (int i = 1; i < split.length; i++) {
                if (!cur.map.containsKey(split[i])) return -1;
                cur = cur.map.get(split[i]);
            }
            return cur.value;
        }
    }
}

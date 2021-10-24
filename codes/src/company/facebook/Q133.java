package company.facebook;

import java.util.*;

public class Q133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        for (Node neighbor : node.neighbors) {
            map.get(node).neighbors.add(cloneGraph(neighbor));
        }
        return map.get(node);
    }

    public Node cloneGraph1(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if (node == null) return null;
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (Node neighbor : poll.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(poll).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

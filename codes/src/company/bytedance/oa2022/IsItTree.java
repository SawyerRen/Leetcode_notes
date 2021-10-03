package company.bytedance.oa2022;

import java.util.*;

public class IsItTree {
    static String solution(Character[][] pairs) {
        boolean[][] graph = new boolean[26][26];
        Set<Character> nodes = new HashSet<>();
        // duplicate
        boolean E2 = false;
        for (Character[] pair : pairs) {
            int x = pair[0] - 'A', y = pair[1] - 'A';
            if (graph[x][y]) E2 = true;
            graph[x][y] = true;
            nodes.add(pair[0]);
            nodes.add(pair[1]);
        }
        // more than two children
        boolean E1 = false;
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (graph[i][j]) count++;
            }
            if (count > 2) return "E1";
        }
        if (E2) return "E2";
        int numOfRoots = 0;
        char root = ' ';
        for (Character node : nodes) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][node - 'A']) break;
                if (i == 25) {
                    numOfRoots++;
                    root = node;
                    boolean[] visited = new boolean[26];
                    if (hasCycle(node, graph, visited)) return "E3";
                }
            }
        }
        if (numOfRoots == 0) return "E3";
        if (numOfRoots > 1) return "E4";
        if (root == ' ') return "E5";
        return getExpression(root, graph);
    }

    private static String getExpression(char root, boolean[][] graph) {
        String left = "", right = "";
        for (int i = 0; i < 26; i++) {
            if (graph[root - 'A'][i]) {
                left = getExpression((char) (i + 'A'), graph);
                for (int j = i + 1; j < 26; j++) {
                    if (graph[root - 'A'][j]) {
                        right = getExpression((char) (j + 'A'), graph);
                        break;
                    }
                }
                break;
            }
        }
        return "(" + root + left + right + ")";
    }

    private static boolean hasCycle(Character node, boolean[][] graph, boolean[] visited) {
        if (visited[node - 'A']) return true;
        visited[node - 'A'] = true;
        for (int i = 0; i < 26; i++) {
            if (graph[node - 'A'][i]) {
                if (hasCycle((char) (i + 'A'), graph, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Character[][] pairs = {{'B', 'D'}, {'D', 'E'}, {'A', 'B'}, {'C', 'F'}, {'E', 'G'}, {'A', 'C'}};
        Character[][] pairs1 = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'D', 'C'}};
        String solution = solution(pairs1);
        System.out.println(solution);
    }
}

package all_solution.q700;

import java.util.*;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        helper(res, list, graph, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[][] graph, int start) {
        if (start == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[start]) {
            list.add(next);
            helper(res, list, graph, next);
            list.remove(list.size() - 1);
        }
    }
}

package topics.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, new LinkedList<>(), nums, visited, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited, int start) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && !visited[i - 1] && nums[i - 1] == nums[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, visited, i + 1);
            visited[i] = false;
            list.removeLast();
        }
    }
}

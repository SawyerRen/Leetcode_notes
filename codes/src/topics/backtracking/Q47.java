package topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

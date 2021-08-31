package topics.backtracking;

import java.util.*;

public class Q491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int index, ArrayList<Integer> list) {
        if (list.size() > 1) res.add(new LinkedList<>(list));
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                visited.add(nums[i]);
                list.add(nums[i]);
                helper(res, nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

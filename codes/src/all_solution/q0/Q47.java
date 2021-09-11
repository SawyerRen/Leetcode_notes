package all_solution.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 如[1,1,2]，当访问第二个1时，如果前一个1没有访问过，就不添加第二个1，否则会再次访问第一个1，出现[1,1,2]这种重复排序
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, nums, visited);
            list.removeLast();
            visited[i] = false;
        }
    }
}

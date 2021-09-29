package company.pimco;

import java.util.List;

// 给两个list，当list中相同index值相等且大于当前最大值时，
// 改变当前最大值，最后输出最大值改变次数
public class Q7 {
    int solution(List<Integer> list1, List<Integer> list2) {
        if (list1.size() == 0 || list2.size() == 0) return 0;
        int size = Math.min(list1.size(), list2.size());
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (list1.get(i).equals(list2.get(i)) && max < list1.get(i)) {
                max = list1.get(i);
                res++;
            }
        }
        return res;
    }
}

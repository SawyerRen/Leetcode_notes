package company.codesignal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给一个数组，元素在[10^-9,10^9]范围内表示一个地址，[1,-5,3,2] 表示随着时间增加，依次在1, -5, 3, 2位置修建一座房子，要求返回各个时刻最长的住房区长度，比如一开始只有1位置有房子，最大住房区长度是1, 最后-5,1,2,3有房子，最大住房区长度是3(1,2,3有房子), 这个例子返回[1,1,1,3]
 */
public class LongestHouseLength {
    static int[] solution(int[] input) {
        int[] res = new int[input.length];
        int maxLen = 0;
        int i = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int index : input) {
            int[] lr = new int[]{index, index};
            if (map.containsKey(index - 1)) {
                lr[0] = map.get(index - 1)[0];
            }
            if (map.containsKey(index + 1)) {
                lr[1] = map.get(index + 1)[1];
            }
            map.put(index, lr);
            maxLen = Math.max(maxLen, lr[1] - lr[0] + 1);
            res[i++] = maxLen;
            int[] left = map.get(lr[0]);
            left[1] = lr[1];
            map.put(lr[0], left);
            int[] right = map.get(lr[1]);
            right[0] = lr[0];
            map.put(lr[1], right);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -5, 3, 2, 4,5, 20, 21, 23, 25, 30, 24, 22};
        System.out.println(Arrays.toString(solution(arr)));
    }
}

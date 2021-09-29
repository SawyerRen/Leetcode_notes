package company.pimco;

// 统计一个array中长度为k的单调递增区间一共有几个
public class Q8 {
    static int solution(int[] array, int k) {
        int left = 0;
        int res = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int len = i - left + 1;
                if (len >= k) {
                    res += len - k + 1;
                }
                left = i + 1;
            }
        }
        int len = array.length - left;
        res += len - k + 1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 10, 5, 24, 10, 12};
        int k = 4;
        System.out.println(solution(arr, k));
    }
}

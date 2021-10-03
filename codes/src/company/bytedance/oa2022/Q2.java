package company.bytedance.oa2022;

//给一个int array 要求把所有偶数排到前面 所有奇数排到后面 求从原array变成要求的array最小的swap次数
public class Q2 {
    static int solution(int[] array) {
        int i = 0, j = array.length - 1;
        int res = 0;
        while (i < j) {
            while (i < j && array[i] % 2 == 0) i++;
            while (i < j && array[j] % 2 != 0) j--;
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                res++;
                i++;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(solution(arr));
    }
}

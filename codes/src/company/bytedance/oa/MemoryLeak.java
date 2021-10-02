package company.bytedance.oa;

public class MemoryLeak {
    static int[][] solution(int[][] memory) {
        int[][] res = new int[memory.length][3];
        int i = 0;
        for (int[] m : memory) {
            int m1 = m[0], m2 = m[1];
            int time = 0;
            while (time <= m1 || time <= m2) {
                if (m1 >= m2) {
                    m1 -= time;
                } else {
                    m2 -= time;
                }
                time++;
            }
            int[] output = {time, m1, m2};
            res[i++] = output;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] memory = {{2, 2}, {8, 11}};
        int[][] output = solution(memory);
        for (int[] out : output) {
            for (int i : out) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

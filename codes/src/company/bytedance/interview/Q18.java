package company.bytedance.interview;

/*
Given hours k and meetings with a length in hours and priority score

Find the maximum proierty score you can achieve by you can attending meetings within k

ex
k = 3
meetings = [[1,200],[2,400],[4,400],[3,100]]

output: 600 (meetings[0] + meetings[1]= 600)

ex
k = 6
meetings = [[1,200],[2,400],[4,400],[2,100],[5,500]]

output: 800 (meetings[1] + meetings[2]= 800)


 */
public class Q18 {
    static int solution(int k, int[][] meetings) {
        int n = meetings.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j - meetings[i - 1][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - meetings[i - 1][0]] + meetings[i - 1][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int[][] meetings = {{1, 200}, {2, 400}, {4, 400}, {3, 100}};
        System.out.println(solution(3, meetings));
        System.out.println(solution(6, meetings));
    }
}

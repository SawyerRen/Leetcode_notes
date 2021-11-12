package company.fbr4.again;

public class Q825 {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        for (int age : ages) {
            ageCount[age]++;
        }
        int[] ageSum = new int[121];
        int sum = 0, res = 0;
        for (int i = 15; i < 121; i++) {
            sum += ageCount[i];
            ageSum[i] += sum;
            if (ageCount[i] == 0) continue;
            int count = ageSum[i] - ageSum[i / 2 + 7];
            res += ageCount[i] * (count - 1);
        }
        return res;
    }
}

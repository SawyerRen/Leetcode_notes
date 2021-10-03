package company.bytedance.oa2022;

public class Aladdin {
    public int solution(int[] dist, int[] magic) {
        int totalMagic = 0, totalCost = 0;
        for (int i : dist) {
            totalCost += i;
        }
        for (int i : magic) {
            totalMagic += i;
        }
        if (totalCost > totalMagic) return -1;
        int start = 0;
        int curMagic = 0;
        for (int i = 0; i < magic.length; i++) {
            curMagic += magic[i] - dist[i];
            if (curMagic < 0) {
                start = i + 1;
                curMagic = 0;
            }
        }
        return start;
    }
}

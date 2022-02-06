package all_solution.q100;

public class Q165 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int m = split1.length, n = split2.length;
        int i = 0, j = 0;
        while (i < m || j < n) {
            int n1 = i < m ? Integer.parseInt(split1[i]) : 0;
            int n2 = j < n ? Integer.parseInt(split2[j]) : 0;
            if (n1 < n2) return -1;
            if (n1 > n2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}

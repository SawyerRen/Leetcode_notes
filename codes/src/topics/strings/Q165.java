package topics.strings;

public class Q165 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < split1.length || index2 < split2.length) {
            int num1 = index1 < split1.length ? Integer.parseInt(split1[index1]) : 0;
            int num2 = index2 < split2.length ? Integer.parseInt(split2[index2]) : 0;
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            index1++;
            index2++;
        }
        return 0;
    }
}

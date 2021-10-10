package company.codesignal;

import java.util.*;

public class MinDiffOfArrays {
    static int minDiffOfArrays(int[] a, int[] b) {
        int[] diffs = new int[a.length];
        int diffSum = 0;
        for (int i = 0; i < a.length; i++) {
            diffs[i] = Math.abs(a[i] - b[i]);
            diffSum += diffs[i];
        }
        int minDiffSum = diffSum;
        TreeMap<Integer, Integer> valIndexMap = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            valIndexMap.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            Integer ceilingKey = valIndexMap.ceilingKey(b[i]);
            if (ceilingKey != null) {
                int index = valIndexMap.get(ceilingKey);
                minDiffSum = Math.min(minDiffSum, diffSum - (Math.abs(a[i] - b[i])) + Math.abs(a[index] - b[i]));
            }
            Integer floorKey = valIndexMap.floorKey(a[i]);
            if (floorKey != null) {
                int index = valIndexMap.get(floorKey);
                minDiffSum = Math.min(minDiffSum, diffSum - (Math.abs(a[i] - b[i])) + Math.abs(a[index] - b[i]));
            }
        }
        return minDiffSum;
    }

    public static void main(String[] args) {
        int[] a = {6, 13, 19, 48, 74, 75, 85, 86, 88, 98};
        int[] b = {1012, 1024, 1160, 1518, 1525, 1539, 1682, 1717, 1762, 1947};
        System.out.println(minDiffOfArrays(a, b));
    }
}

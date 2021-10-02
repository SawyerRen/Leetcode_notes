package company.bytedance.interview;

import java.util.ArrayList;
import java.util.List;

/*
Merge two sorted integer arrays, remove duplicates.
 */
public class Q4 {
    static int[] merge(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                list.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                list.add(arr2[j++]);
            } else {
                list.add(arr1[i++]);
                j++;
            }
        }
        if (i < arr1.length) {
            addRemaining(list, arr1, i);
        } else {
            addRemaining(list, arr2, j);
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    private static void addRemaining(List<Integer> list, int[] arr1, int start) {
        for (int i = start; i < arr1.length; i++) {
            if (arr1[i] == list.get(list.size() - 1)) continue;
            list.add(arr1[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 45, 61, 90};
        int[] arr2 = {1, 4, 45, 61, 223, 12312};
        for (int i : merge(arr1, arr2)) {
            System.out.println(i);
        }
    }
}

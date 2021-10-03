package company.bytedance.oa2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TensorIteration {
    static List<String> iterate(int[] shape) {
        List<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < shape[shape.length - 1]; i++) {
            list1.add(String.valueOf(i));
        }
        for (int i = shape.length - 2; i >= 0; i--) {
            int size = shape[i];
            for (int j = 0; j < size; j++) {
                for (String s : list1) {
                    list2.add(j + "," + s);
                }
            }
            list1 = new ArrayList<>(list2);
            list2.clear();
        }
        return list1;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 2};
        List<String> res = iterate(input);
        System.out.println(res);
    }
}

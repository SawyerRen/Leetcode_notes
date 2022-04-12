package all_solution.q1300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1352 {
    class ProductOfNumbers {
        List<Integer> preProduct = new ArrayList<>();

        public ProductOfNumbers() {

        }

        public void add(int num) {
            if (num == 0) {
                preProduct.clear();
                return;
            }
            if (preProduct.isEmpty()) {
                preProduct.add(num);
            } else {
                preProduct.add(num * preProduct.get(preProduct.size() - 1));
            }
        }

        public int getProduct(int k) {
            if (k > preProduct.size()) return 0;
            if (k == preProduct.size()) return preProduct.get(preProduct.size() - 1);
            return preProduct.get(preProduct.size() - 1) / preProduct.get(preProduct.size() - k - 1);
        }
    }
}

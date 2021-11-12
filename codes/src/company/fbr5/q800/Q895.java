package company.fbr5.q800;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            maxFreq = Math.max(maxFreq, freq);
            freqMap.put(val, freq);
            stackMap.putIfAbsent(freq, new Stack<>());
            stackMap.get(freq).add(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(maxFreq);
            Integer val = stack.pop();
            freqMap.put(val, freqMap.get(val) - 1);
            if (stack.size() == 0) maxFreq--;
            return val;
        }
    }
}

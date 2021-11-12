package company.fbr4.q800;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int val) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            int freq = freqMap.get(val);
            maxFreq = Math.max(maxFreq, freq);
            stackMap.putIfAbsent(freq, new Stack<>());
            stackMap.get(freq).add(val);
        }

        public int pop() {
            int val = stackMap.get(maxFreq).pop();
            if (stackMap.get(maxFreq).isEmpty()) maxFreq--;
            freqMap.put(val, freqMap.get(val) - 1);
            return val;
        }
    }
}

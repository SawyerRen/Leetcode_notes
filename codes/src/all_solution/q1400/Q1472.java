package all_solution.q1400;

import java.util.Stack;

public class Q1472 {
    class BrowserHistory {
        Stack<String> forwardStack;
        Stack<String> backStack;

        public BrowserHistory(String homepage) {
            forwardStack = new Stack<>();
            backStack = new Stack<>();
            backStack.push(homepage);
        }

        public void visit(String url) {
            forwardStack.clear();
            backStack.push(url);
        }

        public String back(int steps) {
            while (steps > 0 && backStack.size() > 1) {
                forwardStack.push(backStack.pop());
                steps--;
            }
            return backStack.peek();
        }

        public String forward(int steps) {
            while (steps > 0 && !forwardStack.isEmpty()) {
                backStack.push(forwardStack.pop());
                steps--;
            }
            return backStack.peek();
        }
    }
}

package all_solution.q900;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q901 {
}

class StockSpanner {
    class Stock {
        int price;
        int span;

        public Stock(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Stock> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) {
            span += stack.pop().span;
        }
        stack.push(new Stock(price, span));
        return span;
    }
}
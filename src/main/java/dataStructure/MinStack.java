package dataStructure;

import java.util.Stack;

/**
 * @author : zzh
 * create at:  2020/8/8
 * @description:
 */
public class MinStack {

    private int minimum = Integer.MAX_VALUE;

    private Stack<Integer> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        if (x <= minimum) {
            stack.push(minimum);
            minimum = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == minimum) {
            minimum = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}

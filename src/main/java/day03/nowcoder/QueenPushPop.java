package day03.nowcoder;

import java.util.Stack;

/**
 * @author ZerlindaLi create at 2019/9/24 17:03
 * @version 1.0.0
 * @description QueenPushPop 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 栈是后进先出
 * 队列是先进先出
 */
public class QueenPushPop {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 栈的push方法向栈中添加元素,返回结果是当前添加的元素
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * pop方法移除并返回栈顶元素，如果是空栈，会抛出异常：EmptyStackException
     * @return
     */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int st2 = stack2.pop();

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return st2;
    }

    public static void main(String[] args) {
        QueenPushPop qpp = new QueenPushPop();
        qpp.push(5);
        qpp.push(2);
        qpp.push(3);
        qpp.push(4);
        System.out.println(qpp.pop());
    }
}

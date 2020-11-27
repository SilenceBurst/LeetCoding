package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackTest {

    /**
     * Stack 栈 LIFO(Last In First Out) 后进先出
     * 最后入栈的元素一定最早出栈，如何做到？把栈的一端封死
     *
     * <p> api：
     *      push() 向栈中压入元素
     *      pop() 把栈顶的元素弹出
     *      peek() 获取栈顶元素但不弹出
     *
     * <p> java中用Deque实现Stack，Stack类不再推荐被直接使用
     *      两种常用的实现：ArrayDeque vs LinkedList
     *          ArrayDeque 内部实现是数组 访问元素速度更快
     *          LinkedList 内部实现是链表 插入/删除元素速度更快
     *
     *      push() == addFirst()
     *      pop() == removeFirst()
     *      peek() == peekFirst()
     *
     */
    public static void main(String[] args) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.push(1);
        stack1.pop();
        stack1.peek();

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.pop();
        stack.peek();
    }
}

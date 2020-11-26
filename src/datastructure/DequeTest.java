package datastructure;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    /**
     * 双端队列
     *
     * <p> 向队列中插入null值 是不合法的
     *
     * 对比Queue有增加了一套从队尾获取/增加/删除元素的api
     * 队首                             队尾
     * 获取元素     peekFirst/getFirst              peekLast/getLast
     * 添加元素     offerFirst/addFirst             offerLast/addLast
     * 删除元素     pollFirst/removeFirst           pollLast/removeLast
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

    }
}

package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    /**
     * <p> 先进先出 FIFO：First In First Out
     *
     * <p> java 实现LinkedList
     *
     * <p> 向队列中插入null值 是不合法的
     *
     * <p> add vs offer 均是增加一个元素
     * 如果队列已满，add 抛出IllegalStateException异常
     * offer 返回false；队列未满，成功添加返回true
     *
     * <p> remove vs poll 均是移除并返回头部元素
     * 如果队列为空，remove 抛出异常
     * poll  返回null
     *
     * <p> element vs peek 均是获取头部元素
     * 如果队列为空，remove 抛出异常
     * poll  返回null
     *
     * <p> put  添加一个元素 如果队列已满，则阻塞
     * take 移除并返回头部元素 如果队列为空，则阻塞
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

    }
}

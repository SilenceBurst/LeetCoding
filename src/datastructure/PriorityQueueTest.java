package datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    /**
     * 优先队列 FIFO vip
     *
     * <p> 元素的入队顺序与元素优先级有关，优先级最高的元素排在队首，会被最先取出
     *
     * <p> 优先级的比较，通过元素的Comparable或者构造PriorityQueue时传入Comparator，类似TreeMap/TreeSet
     */
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("b");
        priorityQueue.offer("c");
        priorityQueue.offer("a");
        while (!priorityQueue.isEmpty()) {
            String poll = priorityQueue.poll();
            // a
            // b
            // c
            System.out.println(poll);
        }
    }
}

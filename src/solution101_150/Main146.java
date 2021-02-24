package solution101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 */
public class Main146 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(1)
     *      get时：
     *          从HashMap中获取元素复杂度为O(1)，如果元素存在，删除元素O(1)+头部添加元素O(1)
     *                                       else直接返回-1
     *      put时：
     *          从HashMap中获取元素复杂度为O(1)，如果元素存在，删除元素O(1)+头部添加元素O(1)+更新value值O(1)
     *                                       else 头部添加元素O(1)+map中添加元素O(1)+可能的删除尾部元素O(1)
     *
     * 空间复杂度：O(capacity) HashMap和双向链表最多保存capacity+1个元素
     */
    public class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private int size;
        private DLinkedNode head;
        private DLinkedNode tail;
        private Map<Integer, DLinkedNode> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 如果当前key不存在返回-1
         * 如果当前key存在，将节点移动到链表头部，返回value值
         */
        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        /**
         * 如果当前key存在，将链表中该key移动到链表头部，更新value值
         * 如果key不存在，判断size是否超出
         * 未超出就创建节点并添加到链表头部
         * 如超出，移除链表尾部最久使用元素，创建节点并添加到链表头部
         */
        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                addToHead(newNode);
                map.put(key, newNode);
                size++;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    map.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private DLinkedNode removeTail() {
            DLinkedNode node = tail.prev;
            removeNode(node);
            return node;
        }
    }
}

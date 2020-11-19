package solution551_600;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 */
public class Main590 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 本来以为挺简单 结果吭哧半天没做出来+1
     * 时间复杂度：O(N) 每个节点均需要且只需要遍历一次
     * 空间复杂度：平均状态下**应该**是：O(log N)；最坏情况下为：O(N)，只有2层，需要将N-1（假设所有节点总数为N）个子元素添加到栈中
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            if (node.children != null) {
                for (Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点均需要且只遍历一次
     * 空间复杂度：平均状态下**应该**是O(log N) 最坏情况为链表O(N) 最好情况是N叉树只有两层 只需要递归一次
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> result) {
        if (node != null) {
            if (node.children != null) {
                for (Node child : node.children) {
                    helper(child, result);
                }
            }
            result.add(node.val);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

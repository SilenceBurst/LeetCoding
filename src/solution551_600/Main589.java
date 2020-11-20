package solution551_600;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 */
public class Main589 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 时间复杂度：O(N) 每个节点均会被遍历只遍历到一次
     * 空间复杂度：平均状态下为O(log N)；最坏情况为N叉树只有两层，根节点从栈中移除后，需要把N-1个节点加入栈中
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    if (child != null) {
                        stack.add(child);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点均需要且只被遍历一次
     * 空间复杂度：平均状态下为O(log N)，最坏状态下N叉树为链表为O(N)
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    helper(child, result);
                }
            }
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


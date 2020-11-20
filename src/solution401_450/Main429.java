package solution401_450;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 */
public class Main429 {

    public static void main(String[] args) {

    }

    /**
     * 广度优先搜索
     * 需要从根节点向下遍历树，然后向下搜索最接近根节点的节点，是广度优先搜索
     * 使用队列来进行广度优先搜索，队列具有先进先出的特性
     * 这里使用栈是错误的选择，栈应用于深度优先搜索
     * 时间复杂度：O(N)
     * 空间复杂度：平均情况下为O(log N)；最坏情况下为O(N)，只有两层，队列中移除根节点后，需要将N-1个子节点加入
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.addAll(node.children);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 迭代解法 简化的广度优先搜索
     * 时间复杂度：O(N)
     * 空间复杂度：平均情况下为：O(log N)；最坏状态为只有两层，需要把N-1个节点加入栈中，复杂度为O(N)
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<Node> currStack = new ArrayList<>();
        currStack.add(root);
        while (!currStack.isEmpty()) {
            ArrayList<Node> nextStack = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (Node node : currStack) {
                list.add(node.val);
                nextStack.addAll(node.children);
            }
            result.add(list);
            currStack = nextStack;
        }
        return result;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点均会被遍历且只被遍历一次
     * 空间复杂度：平均状态下为O(log N)；最坏状态为链表O(N) 堆栈的深度
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(Node node, List<List<Integer>> result, int level) {
        if (node != null) {
            if (result.size() <= level) result.add(new ArrayList<>());
            result.get(level).add(node.val);
            for (Node child : node.children) {
                helper(child, result, level + 1);
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

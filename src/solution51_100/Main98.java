package solution51_100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 98. 验证二叉搜索树
 * 二叉搜索树的中序遍历是升序
 */
public class Main98 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法 中序遍历是升序
     * 时间复杂度：O(N) 每个节点均需要且最多遍历一次
     * 空间复杂度：平均状态下为O(log N)，最坏状态下为O(N)，是一个只有左子树的链表，栈中需要保存所有节点
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        Integer preVal = null;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (preVal != null && root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点均需要且最多遍历一次
     * 空间复杂度：O(N) 平均状态下为O(log N)，最坏状态下为O(N)，二叉树退化成链表
     */
    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int value = node.val;
        if (lower != null && value <= lower) {
            return false;
        }
        if (upper != null && value >= upper) {
            return false;
        }
        if (!helper(node.left, lower, value)) {
            return false;
        }
        if (!helper(node.right, value, upper)) {
            return false;
        }
        return true;
    }

    /**
     * 迭代解法 不推荐 leetcode需要的时间最久
     * 维护三个队列 分别保存当前node和边界值
     * 时间复杂度：O(N) 每个节点均会被且只会被遍历一次
     * 空间复杂度：O(N) 平均状态下为O(N/2 * 3)，最坏状态下为O(N * 3)，只有左侧子节点
     */
    public boolean isValidBST(TreeNode root) {
        update(root, null, null);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower = lowers.poll();
            Integer upper = uppers.poll();
            if (node == null) continue;
            if (lower != null && lower >= node.val) return false;
            if (upper != null && upper <= node.val) return false;
            update(node.right, node.val, upper);
            update(node.left, lower, node.val);
        }
        return true;
    }

    private Queue<TreeNode> stack = new LinkedList<>();
    private Queue<Integer> lowers = new LinkedList<>();
    private Queue<Integer> uppers = new LinkedList<>();

    private void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

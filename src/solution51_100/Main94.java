package solution51_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class Main94 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 时间复杂度：O(N)
     * 空间复杂度：取决于数的结构，如果变化成链表，最高达到O(N)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            // 内层while用于对当前节点及当前节点下左右左节点做入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 当前节点下没有左节点 可以把当前节点的值添加到结果中了
            // 并且对当前节点的右节点 开始上一操作即遍历它的所有左节点 直至没有
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }
        return result;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N)
     * 空间复杂度：取决于递归的栈的深度，一般为O(log N)；但在二叉树为一条链时，达到O(N)
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper1(root, result);
        return result;
    }

    private void helper1(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper1(node.left, result);
            result.add(node.val);
            helper1(node.right, result);
        }
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package solution101_150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class Main144 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 时间复杂度：O(N)
     * 空间复杂度：平均状态下为O(log N) 最坏状态下为链表 O(N)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N)
     * 空间复杂度：平均状态下为O(log N) 最坏状态下为链表 O(N)
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            helper(node.left, result);
            helper(node.right, result);
        }
    }

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

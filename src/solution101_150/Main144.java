package solution101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class Main144 {

    public static void main(String[] args) {

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

    /**
     * 递归解法
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        helper1(output, root);
        return output;
    }

    public static void helper1(List<Integer> output, TreeNode node) {
        if (node != null) {
            output.add(node.val);
            helper1(output, node.left);
            helper1(output, node.right);
        }
    }

    /**
     * 迭代解法
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}

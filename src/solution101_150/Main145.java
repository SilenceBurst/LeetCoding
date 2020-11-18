package solution101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class Main145 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 这题好难 想了好久 想不出来
     * 难点是：
     *      1. 记录上次添加到结果中的节点，遍历中间节点时，它的右节点 == 上次添加的节点，代表中间节点的左右节点值均添加过了，
     *         就可以添加中间节点的值
     *      2. root = null，向上继续遍历
     * 时间复杂度：O(N) 每个节点都需要遍历一次
     * 空间复杂度：平均状态下O(log N)，最坏情况为链表：O(N)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 从下向上依次记录已遍历的右节点值，如果已记录过，可以添加中间节点的值了
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 当没有右节点，或者中心节点的右节点 == 刚刚被添加到结果中的节点
            // 表示此节点的左右均已被添加，才会添加该节点的值，并把root置null，向上层节点遍历
            if (root.right == null || prev == root.right) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }


    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点都需要遍历一次
     * 空间复杂度：平均境况下为：O(log N)  最坏状态下为链表：O(N)
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper(node.left, result);
            helper(node.right, result);
            result.add(node.val);
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

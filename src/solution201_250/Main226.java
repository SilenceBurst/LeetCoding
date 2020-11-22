package solution201_250;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 */
public class Main226 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 时间复杂度：O(N) 每个节点只被遍历一次
     * 空间复杂度：O(N) 最坏情况下，队列中会包含该层的所有元素，对于最后一层来说，该层的节点数可能大于等于N/2，所以其空间复杂度为O(N)
     * 复杂度分析见：
     * https://leetcode.com/problems/invert-binary-tree/solution/jsti-jie-di-gui-die-dai-by-wumeilian/
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点都需要被遍历
     * 空间复杂度：平均状态下为O(log N)，最坏状态下为O(N)，二叉树退化成链表 递归深度=链表长度
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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

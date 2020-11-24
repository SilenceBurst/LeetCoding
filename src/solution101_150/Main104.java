package solution101_150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 类似二叉树的层序遍历
 */
public class Main104 {

    public static void main(String[] args) {

    }

    /**
     * 迭代 广度优先搜索 类似二叉树的层序遍历
     * 时间复杂度：O(N) 每个节点都会被且只会被访问一次
     * 空间复杂度：O(N) 平均状态下队列中需要保存O(n/2 + 1 个节点)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return maxDepth;
    }

    /**
     * 递归解法
     * 时间复杂度：O(N) 每个节点均会被且只会被遍历一次
     * 空间复杂度：O(height) 平均情况下为O(log N)，最坏情况下为O(N)退化成链表
     * 递归函数需要栈空间，而栈空间取决于递归的深度，递归的深度等于二叉树的高度
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
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

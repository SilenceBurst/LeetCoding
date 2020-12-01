package solution101_150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class Main111 {

    public static void main(String[] args) {

    }

    /**
     * 迭代解法 广度优先搜索
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) 空间复杂度主要取决于队列的开销，队列中的元素个数不会超过节点数 平均状态下应该为O(N/2/2)
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                } else {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return minDepth;
    }

    /**
     * 遍历解法 深度优先搜索
     * 时间复杂度：O(N)
     * 空间复杂度：O(H) 空间复杂度主要取决于递归时栈的开销，最坏情况下为O(N)，二叉树退化成链表；平均状态下为O(log N)
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth1(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth1(root.left) + 1;
        }
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
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

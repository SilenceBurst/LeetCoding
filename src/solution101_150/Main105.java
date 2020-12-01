package solution101_150;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Main105 {

    public static void main(String[] args) {

    }

    /**
     * 太难想明白了
     * 迭代解法 其实是按照前序遍历的顺序，根据中序遍历的指针判断当前元素是否有右儿子，产生右侧、上层偏移，继续前序遍历
     * 时间复杂度：O(N) preorder循环中，所有节点需要被遍历一次，while循环中，所有节点又需要出栈一次 O(2N) = O(N)
     * 空间复杂度：O(N) 栈中元素个数为二叉树深度，最坏情况下为链表 O(N)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // 栈中的节点是根节点 或者均和其它节点建立过关系了
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            // 这个判断很强
            // inorder[inorderIndex] != node.val 说明preorder之后存在node.val的左儿子
            if (inorder[inorderIndex] != node.val) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                // stack.peek().val == inorder[inorderIndex]，说明栈顶的元素位于当前中序遍历阶段的最左端，
                // 前序遍历需要右侧偏移，栈顶就可以出栈了，同时中序遍历可以向右侧、上层移动 == 中序遍历的index++
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 如果有出栈元素有右节点，那么栈顶元素值必定不等于inorder[inorderIndex]
                // preorder[i]节点是刚刚出栈的元素的右节点，接着判断preorder[i]压入栈中，遍历它左儿子和右儿子
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 递归解法 其实是对二叉树的层序遍历
     * <p>
     * preLeft是层序遍历的指针，不断向深层递归
     * <p>
     * 以当前遍历到的节点为根节点，preLeft和preRight是根节点的所有左子节点和所有右子节点在preorder中的左右边界
     * <p>
     * 当前根节点的左子节点为在前序遍历中下标为preLeft+1的元素
     * 当前根节点的右子节点为在前序遍历中下标为preLeft+leftChildCount+1的元素
     * <p>
     * inLeft是当前根节点在中序遍历结果中，左子节点的边界
     * <p>
     * 由当前根节点在中序遍历中的节点下标和左子节点的边界可以计算出，左子节点的数量
     * 可以确定左子节点的所有子节点在preorder中的左右边界为[preLeft+1, preLeft+左子节点的数量]
     * 可以确定右子节点的所有子节点在preorder中的左右边界为[preLeft+leftChildCount+1, preorder.length-1]
     * <p>
     * 将左/右子节点作为根节点向下层遍历
     * <p>
     * 时间复杂度：O(N) 对二叉树进行一次中序遍历和一次层序遍历，均只对同一个节点访问一次，为O(2N) = O(N)
     * 空间复杂度：O(N) HashMap需要O(N)的空间保存中序遍历的所有元素，递归的深度不超过节点个数，为O(2N) = O(N)
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 以中序遍历的值为key，下标为value保存在map中，用于确定指定值在中序遍历中的节点下标
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0);
    }

    private Map<Integer, Integer> inOrderMap;

    private TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }
        int rootInorderIndex = inOrderMap.get(preorder[preLeft]);
        int leftChildCount = rootInorderIndex - inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTreeHelper(preorder, preLeft + 1, preLeft + leftChildCount, inLeft);
        root.right = buildTreeHelper(preorder, preLeft + leftChildCount + 1, preRight, rootInorderIndex + 1);
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

package solution201_250;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 */
public class Main236 {

    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     *
     * 利用hash表保存以节点值为key、对应的父节点为value，保存除根节点以外的所有节点
     * 保存完成后，从p节点开始，依次记录它的所有父节点，
     * 记录完成后，从q节点开始，依次向上遍历它的父节点，若某节点是被记录的p的父节点，则为最近公共祖先
     *
     * 时间复杂度：O(N) dfs需要遍历所有节点为O(N)；
     *                而p和q向上遍历父节点的时间复杂度最高为O(N)；
     *                所以总的时间复杂度为O(N)
     * 空间复杂度：O(N) dfs时空间复杂度等于二叉树高度，最坏情况下为O(N)；
     *                map(包含除根节点外的所有节点)的空间复杂度为O(N-1)-->O(N)；
     *                hashSet中保存的节点树最高也为O(N)；
     *                所以总的空间复杂度为O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root);
        while (p != null) {
            set.add(p);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                map.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                dfs(root.right);
            }
        }
    }

    private Map<Integer, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();


    /**
     * 递归解法 深度优先搜索
     * 对于某个节点定义一个函数f(x)，如果返回为true，表示x节点仅仅包含p/q其中一个节点
     *
     * 则最近公共祖先x节点必然只有以下情况：
     *      1. f(x.left) && f(x.right)
     *          p/q两个节点分别位于x节点的左子树和右子树中
     *      2. (p == x.val || q == x.val) && (f(left) || f(right))
     *          p/q其中一个 == x，并且另一个位于x的左子树或右子树中
     * 正确性：
     *      由于采用的是深度优先搜索，当最近公共祖先x被找到时，x可能会作为父节点的左节点/右节点，
     *      按照上面最近公共祖先的两种情况定义，则必有f(x的右节点/左节点)为false，并且x的父节点值不可能等于p/q，
     *      即之后的不是最近的公共祖先不再满足条件
     *
     * 时间复杂度：O(N) 每个节点只会被遍历一次
     * 空间复杂度：O(H) H为二叉树的高度，最坏情况为二叉树退化成链表，高度==节点个数，复杂度为O(N)
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs1(root, p, q);
        return result;
    }

    private boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftRes = dfs1(root.left, p, q);
        boolean rightRes = dfs1(root.right, p, q);
        if ((leftRes && rightRes)
                || ((root.val == p.val || root.val == q.val) && (leftRes || rightRes))) {
            result = root;
        }
        return leftRes || rightRes || (root.val == p.val || root.val == q.val);
    }

    private TreeNode result = null;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

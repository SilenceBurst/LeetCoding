package solution251_300;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * <p>
 * 什么是序列化：
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 */
public class Main297 {

    public static void main(String[] args) {
    }

    /**
     * 前序遍历
     * 序列化：递归
     * 反序列化：迭代
     * 时间复杂度：O(N) 每个节点只会被访问一次
     * 空间复杂度：O(N) 递归的深度和迭代是队列的长度最大等于节点个数
     */
    // Encodes a tree to a single string. 二叉树的前序遍历
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("N,");
        } else {
            result.append(node.val).append(",");
            serializeHelper(node.left, result);
            serializeHelper(node.right, result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // split方法最后空字符串会被忽略，不会添加到结果中
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(LinkedList<String> list) {
        if ("N".equals(list.get(0))) {
            list.poll();
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.poll()));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);
        return node;
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

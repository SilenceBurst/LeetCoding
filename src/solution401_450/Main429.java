package solution401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 */
public class Main429 {

    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 递归解法
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Node> currNodes = new ArrayList<>();
        ArrayList<Node> nextNodes = new ArrayList<>();
        currNodes.add(root);
        helper1(res, currNodes, nextNodes);
        return res;
    }

    public void helper1(List<List<Integer>> res, ArrayList<Node> currNodes, ArrayList<Node> nextNodes) {
        if (currNodes.isEmpty()) {
            return;
        }
        ArrayList<Integer> inner = new ArrayList<>();
        for (Node item : currNodes) {
            inner.add(item.val);
            if (item.children != null) {
                nextNodes.addAll(item.children);
            }
        }
        res.add(inner);
        currNodes.clear();
        currNodes.addAll(nextNodes);
        nextNodes.clear();
        helper1(res, currNodes, nextNodes);
    }
}

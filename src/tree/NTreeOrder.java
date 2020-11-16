package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NTreeOrder {

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

    // 递归
    public static List<Integer> perOrder1(Node node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper1(arrayList, node);
        return arrayList;
    }

    public static void helper1(ArrayList<Integer> arrayList, Node node) {
        if (node == null) {
            return;
        }
        arrayList.add(node.val);
        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            helper1(arrayList, child);
        }
    }

    // 迭代
    public static List<Integer> perOrder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            if (node != null) {
                output.add(node.val);
                if (node.children != null) {
                    Collections.reverse(node.children);
                    stack.addAll(node.children);
                }
            }
        }
        return output;
    }
}

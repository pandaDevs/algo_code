package code.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth2 {

    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int depth = 0;
        for(Node childNode : root.children) {
            depth = Math.max(depth, maxDepth(childNode));
        }

        return depth + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

package code.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;
            int levelNums = queue.size();
            for(int i = 0; i < levelNums; ++i) {
                Node node = queue.poll();
                List<Node> children = node.children;
                if(children != null) {
                    for(Node childNode : children) {
                        if(childNode != null) {
                            queue.offer(childNode);
                        }
                    }
                }
            }
        }

        return depth;
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

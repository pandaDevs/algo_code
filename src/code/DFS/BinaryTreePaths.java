package code.DFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<String> ret = new ArrayList<>();
        preOrder(root, ret, "");

        return ret;
    }

    private void preOrder(TreeNode node, List<String> ret, String pathBuilder) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            pathBuilder += node.val;
            ret.add(pathBuilder);
            return;
        }
        pathBuilder += node.val + "->";

        preOrder(node.left, ret, pathBuilder);
        preOrder(node.right, ret, pathBuilder);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node1);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        BinaryTreePaths path = new BinaryTreePaths();
        path.binaryTreePaths(root);
    }
}

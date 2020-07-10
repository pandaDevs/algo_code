package code.DFS;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public class TreeNode {
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

    List<Integer> array;
    public TreeNode increasingBST(TreeNode root) {
        array = new ArrayList<>();
        if(root == null) {
            return null;
        }
        buildInOrder(root);
        TreeNode newRoot;
        TreeNode pre = new TreeNode(array.get(0));
        newRoot = pre;
        for(int i = 1; i < array.size(); ++i) {
            TreeNode node = new TreeNode(array.get(i));
            pre.right = node;
            pre = node;
        }

        return newRoot;
    }

    private void buildInOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        buildInOrder(node.left);
        array.add(node.val);
        buildInOrder(node.right);
    }
}

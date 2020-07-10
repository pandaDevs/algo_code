package code.BFS;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(Math.abs(height(root.left) - height(root.right)) == 1 || Math.abs(height(root.left) - height(root.right)) == 0) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int depth = 0;
        if(node.left != null) {
            depth = Math.max(depth, height(node.left));
        }
        if(node.right != null) {
            depth = Math.max(depth, height(node.right));
        }

        return depth + 1;
    }

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
}

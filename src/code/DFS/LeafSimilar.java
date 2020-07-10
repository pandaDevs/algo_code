package code.DFS;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>(202);
        List<Integer> root2List = new ArrayList<>(202);
        getLeafList(root1, root1List);
        getLeafList(root2, root2List);

        if(root1List.size() != root2List.size()) {
            return false;
        }

        for(int i = 0; i < root1List.size(); ++i) {
            if(!root1List.get(i).equals(root2List.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void getLeafList(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            list.add(node.val);
        }

        getLeafList(node.left, list);
        getLeafList(node.right, list);
    }
}

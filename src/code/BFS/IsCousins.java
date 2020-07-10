package code.BFS;

import java.util.LinkedList;
import java.util.Queue;

import apple.laf.JRSUIUtils.Tree;

public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean appear = false;
            boolean cousin = false;
            for(int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                    if(node.right != null) {
                        if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                            return false;
                        }
                    }
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

                if(node.val == x || node.val == y) {
                    if(!appear) {
                        appear = true;
                    } else {
                        cousin = true;
                    }
                }
            }
            if(cousin) {
                return true;
            }

            if(appear && !cousin) {
                return false;
            }
        }
        return false;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {};
        TreeNode(int val) {
            this.val = val;
        }
    }
}

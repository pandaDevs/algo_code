package code.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ret;
        }

        queue.offer(root);
        int levelSize = 1;
        while(!queue.isEmpty()) {
            List<Integer> levelNums = new ArrayList<>();
            for(int i = 0; i < levelSize; ++i) {
                TreeNode tree = queue.poll();
                if(tree.left != null) {
                    queue.offer(tree.left);
                }

                if(tree.right != null) {
                    queue.offer(tree.right);
                }

                levelNums.add(tree.val);
            }
            levelSize = queue.size();

            ret.add(0, levelNums);
        }

        return ret;
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

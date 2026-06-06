/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
    Binary tree not BST
    - returned list needs to be in order of each level
    - while loop to explore in breadth-first search order
    - each level gets an inner loop to see all left & right nodes in that level

    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if(root==null) return levelOrderList;
        Queue<TreeNode> levels = new LinkedList<>();

        levels.offer(root);

        while(!levels.isEmpty()){
            int size = levels.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size>0){
                TreeNode curr = levels.poll();
                currLevel.add(curr.val);
                if(curr.left!=null) levels.offer(curr.left);
                if(curr.right!=null) levels.offer(curr.right);
                size--;
            }
            levelOrderList.add(currLevel);
        }

        return levelOrderList;
    }
}

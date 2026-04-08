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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        return swapTreeNodes(root);
    }

    private TreeNode swapTreeNodes(TreeNode branch){
        if(branch==null) return branch;
        swapTreeNodes(branch.left);
        swapTreeNodes(branch.right);
        TreeNode tempL = branch.left;
        branch.left = branch.right;
        branch.right = tempL;
        return branch;
    }
}

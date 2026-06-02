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

    private int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameter;
    }

    private int calculateDiameter(TreeNode curr){
        if(curr==null)return 0;

        int left = calculateDiameter(curr.left);
        int right = calculateDiameter(curr.right);

        maxDiameter = Math.max(maxDiameter, left+right);

        return 1+Math.max(left,right);
    }
}

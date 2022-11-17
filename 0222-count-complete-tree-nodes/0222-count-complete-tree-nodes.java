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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int right = heightRight(root);
        int left = heightLeft(root);
        if(left==right) return (int)Math.pow(2, left) -1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
     
    public int heightRight(TreeNode root){
        if(root == null) return 0;
        return heightRight(root.right) + 1;
    }
    
    public int heightLeft(TreeNode root){
        if(root == null) return 0;
        return 1 + heightLeft(root.left);
    }
}
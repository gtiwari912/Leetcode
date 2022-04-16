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
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return root;
        solve(root, 0, false);
        return root;
    }
    
    private void solve(TreeNode node, int buffer, boolean isLeft){
        if(node==null)
            return;
        
        if(isLeft){
            node.val = node.val + sum(node.right, 0) + buffer;
        }
        else{
            node.val = node.val + sum(node.right, 0)+buffer;
        }
        solve(node.left, node.val, true);
        solve(node.right, buffer, false);
    }
    
    private int sum(TreeNode node, int curSum){
        if(node==null)
            return curSum;
        
        int leftSum = sum(node.left, 0);
        int rightSum = sum(node.right, 0);
        return leftSum+rightSum+node.val;
    }
}
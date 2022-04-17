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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        TreeNode dummy = new TreeNode(0);
        TreeNode dummy2 = dummy;
        for(int cur: inorder){
            dummy.right = new TreeNode(cur);
            dummy = dummy.right;
        }
        
        
        return dummy2.right;
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
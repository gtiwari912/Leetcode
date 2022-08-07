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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n==0) return null;
        if(n==1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int rootVal = root.val;
        int rightStartIndex = -1;
        for(int i = 0; i<n; i++){
            int ele = preorder[i];
            if(ele>rootVal){
                rightStartIndex = i;
                break;
            }
        }
        int[] left;
        if(rightStartIndex==-1)
            left = Arrays.copyOfRange(preorder, 1, n);
        else
            left = Arrays.copyOfRange(preorder, 1, rightStartIndex);
        int[] right;
        if(rightStartIndex==-1){
            right = new int[0];
        }
        else{
            right = Arrays.copyOfRange(preorder, rightStartIndex, n);
        }
        
        root.left = bstFromPreorder(left);
        root.right = bstFromPreorder(right);
        
        return root;
    }
}
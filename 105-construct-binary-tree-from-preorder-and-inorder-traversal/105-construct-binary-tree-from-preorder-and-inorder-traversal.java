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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n <=0) return null;
        HashMap<Integer, Integer> mapIndexing = new HashMap<>();
        for(int i = 0; i<n; i++){
            mapIndexing.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRoot = mapIndexing.get(preorder[0]);
        
        //making of left part;
        int[] leftInorder = new int[indexOfRoot];
        for(int i = 0; i<indexOfRoot; i++)
            leftInorder[i] = inorder[i];
        int leftSize = indexOfRoot;
        int[] leftPreorder = new int[indexOfRoot];
        int iter = 1;
        for(int i = 0; i<indexOfRoot; i++){
            leftPreorder[i] = preorder[iter++];
        }
        TreeNode leftTree = buildTree(leftPreorder, leftInorder);
        
        //making rightPart;
        int rightSize = (n-1) - indexOfRoot;
        int[] rightInorder = new int[rightSize];
        iter = indexOfRoot+1;
        for(int i = 0; i<rightSize; i++){
            rightInorder[i] = inorder[iter++];
        }
        int[] rightPreorder = new int[rightSize];
        iter = leftSize+1;
        for(int i= 0; i<rightSize; i++){
            rightPreorder[i] = preorder[iter++];
        }
        TreeNode rightTree = buildTree(rightPreorder, rightInorder);
        
        root.left = leftTree;
        root.right = rightTree;
        
        return root;
    }
}
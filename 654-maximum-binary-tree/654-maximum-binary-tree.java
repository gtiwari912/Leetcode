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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n==0)
            return null;
        if(n==1)
            return new TreeNode(nums[0]);
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i<n; i++){
            int ele = nums[i];
            if(ele>max){
                max = ele;
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        int[] leftArr = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightArr = Arrays.copyOfRange(nums, maxIndex+1, n);
        root.left = constructMaximumBinaryTree(leftArr);
        root.right = constructMaximumBinaryTree(rightArr);
        return root;
    }
}
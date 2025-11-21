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
    //intuition: anyway i have to calculate the height of the tree 
    //so why not embedd teh logic in teh same height code
    int diam=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diam;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        diam=Math.max(lh+rh, diam);

        return 1+Math.max(lh,rh);
    }
}
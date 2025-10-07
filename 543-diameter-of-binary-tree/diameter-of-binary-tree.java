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
    int diam=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diam;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftheight=1+height(root.left);
        int rightheight=1+height(root.right);

         diam=Math.max(diam,leftheight+rightheight-2);
         return Math.max(leftheight,rightheight);
    }
}
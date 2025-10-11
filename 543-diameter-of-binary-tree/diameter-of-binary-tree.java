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
        return diam-1;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftheight=1+height(root.left);
        int rightheight=1+height(root.right);
         int temp=Math.max(leftheight-1,rightheight-1)+1;
         int ans=Math.max(leftheight-1+rightheight-1+1,temp);
         diam=Math.max(diam,ans);

         return temp;
    }
}
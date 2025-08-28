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
    // public int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
    public int diameter(TreeNode root){

        if(root==null){
            return 0;
        }
        
        int leftheight=0;
        int rightheight=0;

        if(root.left!=null){
            leftheight=height(root.left);
        }
        if(root.right!=null){
            rightheight=height(root.right);
        }

        int currheight=leftheight+rightheight;

        return Math.max(currheight,Math.max(diameter(root.left),diameter(root.right)));
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}
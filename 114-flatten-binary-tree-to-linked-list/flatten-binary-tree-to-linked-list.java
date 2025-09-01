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
    TreeNode ptr;//global pointer 
    public void flatten(TreeNode root) {
        ptr=root;
        dfs(root);
        //send everything to right;
        helper(root);
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            ptr=root.left;
            dfs(root.left);
        }
        if(root.right!=null){
            ptr.left=root.right;
            root.right=null;
            ptr=ptr.left;
            dfs(ptr);
        }
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        root.right=root.left;
        root.left=null;
        helper(root.right);
    }
}
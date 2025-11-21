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
    // boolean first=true;
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root, long low, long high){
        
        if(root==null){
            return true;
        }
        
        if((long)root.val>=high || (long)root.val<=low){
            return false;
        }

        if((root.left!=null && root.left.val>=root.val)){
            return false;
        }
        
        if(root.right!=null && root.right.val<=root.val){
            return false;
        }
        return valid(root.left,low,root.val) && valid(root.right,root.val,high);
    }
}
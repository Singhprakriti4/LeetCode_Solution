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
   int v=Integer.MIN_VALUE;
   boolean first=true;
    public boolean isValidBST(TreeNode root) {
         if(root==null){
            return true;
        }
        boolean leftans=isValidBST(root.left);
        if(v==Integer.MIN_VALUE && first==true){
            first=false;
            v=root.val;
        }
        else{
            if(root.val<=v)

             return false;
        }
        v=root.val;
        boolean rightans=isValidBST(root.right);
        return leftans && rightans;
    }
    
}
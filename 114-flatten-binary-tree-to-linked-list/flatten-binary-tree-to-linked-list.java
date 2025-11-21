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
    public void flatten(TreeNode root) {
        ll(root);
    }
    public TreeNode ll(TreeNode root){
        if(root==null){
            return null;
        }      
        TreeNode start=root;
        //first flatten the left side if it is not null
        TreeNode leftside=ll(root.left);
        if(leftside==null){
            ll(root.right);
        }
        else{
            //go to the end of the left flattend thing
            TreeNode leftstart=leftside;
            TreeNode leftend=leftside;
            while(leftside.right!=null){
                leftend=leftend.right;
                leftside=leftside.right;
            }

            leftend.right=ll(start.right);
            start.right=leftstart;
            start.left=null;

        }
        return start;
    }
}
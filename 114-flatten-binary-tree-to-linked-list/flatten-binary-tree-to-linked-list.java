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
       flat(root);
    }
    public TreeNode flat(TreeNode root){
         if(root==null){
            return null;
        }
        if(root.left==null){
            root.right=flat(root.right);
        }
        else{
            //flatten the left side
            TreeNode leftchild=root.left;
            TreeNode rightchild=root.right;
            root.left=null;
            root.right=null;
            TreeNode leftflat=flat(leftchild);
            // goto the last node of the left side

            TreeNode ptr=leftflat;
            while(ptr.right!=null){
                ptr=ptr.right;
            }
            ptr.left=null;
            root.right=leftflat;
            ptr.right=flat(rightchild);
            //attach to
        }
        return root;
    }
}
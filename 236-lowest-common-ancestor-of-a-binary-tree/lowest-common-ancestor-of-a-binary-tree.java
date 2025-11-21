/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==p || root==q){
            return root;
        }
        if(root.left==null && root.right==null){
            //reached the leaf but still didn't find the node
            return null;
        }
        TreeNode leftside=null;
        TreeNode rightside=null;

        if(root.left!=null){
            leftside=lca(root.left,p,q);
        }
        if(root.right!=null){
            rightside=lca(root.right,p,q);
        }
        if((leftside==p && rightside==q) ||(leftside==q && rightside==p)){
            return root;
        }
        if(rightside!=null){
            return rightside;
        }
        if(leftside!=null){
            return leftside;
        }
        // System.out.println("rootval: "+root.val);
        return null;
    }
}
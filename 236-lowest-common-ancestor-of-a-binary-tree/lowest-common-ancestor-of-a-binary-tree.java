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
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         helper(root, p, q); 
         return ans;
    }
    public void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return;
        }

        if(contains(root,p) && contains(root,q)){
            ans=root;
        }

        helper(root.left,p,q);
        helper(root.right,p,q);
    }
    public boolean contains(TreeNode root, TreeNode target){
        if(root==null){
            return false;
        }

        if(root.val==target.val){
            return true;
        }

        return contains(root.left, target) || contains(root.right, target);
    }
}
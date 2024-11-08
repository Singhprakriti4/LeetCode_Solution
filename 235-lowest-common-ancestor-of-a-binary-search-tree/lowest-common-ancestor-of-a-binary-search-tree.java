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
        if((root.val>p.val && root.val<q.val)|| (root.val<p.val && root.val>q.val)){
            return root;
        }
        
        if(root.val>p.val && root.val>q.val){
           return lowestCommonAncestor(root.left,p,q);
        }

        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        if((root.val==p.val && hasNode(root,q))||(root.val==q.val && hasNode(root,p)))
        return root;

        return null;
        
    }
    public boolean hasNode(TreeNode root, TreeNode target){
        if(root==null)
        return false;

        if(root.val==target.val)
        return true;

        return hasNode(root.left,target)||hasNode(root.right,target);
    }
}
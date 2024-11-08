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
       lca(root,p,q);
       return ans;
    }
    public void lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
        return;

        if(hasNode(root,p)&&hasNode(root,q))
        ans=root;

        lca(root.left,p,q);
        lca(root.right,p,q);
    }
    public boolean hasNode(TreeNode root, TreeNode target){
        if(root==null){
            return false;
        }
        if(root.val==target.val){
            return true;
        }
        return hasNode(root.left,target)||hasNode(root.right,target);
    }
}
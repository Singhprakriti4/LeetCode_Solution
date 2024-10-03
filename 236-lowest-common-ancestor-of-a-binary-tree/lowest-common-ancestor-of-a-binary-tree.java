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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=root;
        commonnode(root,p,q);
        return ans;
    }
    static boolean contains(TreeNode root,TreeNode target){
     if(root==null)
     return false;
      if(root==target)
    return true;
    return (contains(root.left,target)|| contains(root.right,target));
    }
   private void commonnode(TreeNode root, TreeNode p, TreeNode q){
    if(root==null)
    return;
    if(contains(root,p) && contains(root,q))
    ans=root;
    commonnode(root.left,p,q);
    commonnode(root.right,p,q);
   }
}
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
        if(root.left==null && root.right==null)
        return true;
        return symmetric(root.left,root.right);
    }
static boolean symmetric(TreeNode p,TreeNode q){
    if(p==null && q==null)
    return true;
    else if(p==null){
     return false;
    }
    else if(q==null)
    return false;
    else if(p.val!=q.val)
    return false;
    else 
    return symmetric(p.left,q.right)&&symmetric(p.right ,q.left);
}
}
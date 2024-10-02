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
    boolean ans=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
       preorder(p,q);
       return ans;
    }
    private void preorder(TreeNode p,TreeNode q){
      if(p==null && q==null){
        return;
      }
      else if(p==null || q==null){
        ans=false;
        return;
      }
      else if(p.val!=q.val){
        ans=false;
        return;
      }
      else{
        preorder(p.left,q.left);
        preorder(p.right,q.right);
      }
      
      
    }
}
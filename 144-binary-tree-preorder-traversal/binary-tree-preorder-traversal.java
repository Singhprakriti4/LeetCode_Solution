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
    List<Integer> ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        recu_preorder(root);
        return ans;
    }
    public void recu_preorder(TreeNode root){
        if(root==null){
            return;
        }
        ans.add(root.val);
        recu_preorder(root.left);
        recu_preorder(root.right);
    }
}
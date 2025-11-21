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
    public boolean isBalanced(TreeNode root) {
        HashMap<TreeNode,Integer> h=new HashMap<>();
        return helper(root,h);
    }
    public boolean helper(TreeNode root, HashMap<TreeNode,Integer> h) {
        if(root==null){
            return true;
        }
        if(Math.abs(height(root.left,h)-height(root.right,h))>1) return false;

        return helper(root.left,h) && helper(root.right,h);
    }
    public int height(TreeNode root,HashMap<TreeNode,Integer> h ){
        if(root==null){
            return 0;
        }
        if(h.containsKey(root)){
            return h.get(root);
        }
        h.put(root,Math.max(height(root.left,h),height(root.right,h))+1);
        return h.get(root);
    }
}
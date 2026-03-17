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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return ans;
    }
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=sum(root.left);
        int right=sum(root.right);

        ans=Math.max(ans, Math.max(left+right+root.val, Math.max(left+root.val, 
        Math.max(right+root.val, root.val))));

        return Math.max(left+root.val, 
        Math.max(right+root.val, root.val));

    }
}
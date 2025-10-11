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
    int ans_final=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans(root);
        return ans_final;
    }
    public int ans(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=ans(root.left);
        int right=ans(root.right);

        //ans nahi mila(aage pass krna hai)
        // int badivalue=Math.max(left,right);
        int temp=Math.max(root.val,Math.max(left,right)+root.val);

        //ans mil gyaa hai i.e. root hi an ska bhi root hai
        ans_final=Math.max(temp,Math.max(ans_final,left+right+root.val));
        return temp;
    }
}
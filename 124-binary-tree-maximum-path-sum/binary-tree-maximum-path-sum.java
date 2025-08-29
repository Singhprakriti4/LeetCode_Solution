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
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        int ans= helper(root,max);

       return Math.max(ans,max[0]);
    }
    public int helper(TreeNode root, int[] max){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int left=helper(root.left,max);
        int right=helper(root.right,max);
        int all3=root.val;
        if(left!=Integer.MIN_VALUE){
            all3+=left;
        }
        if(right!=Integer.MIN_VALUE){
            all3+=right;
        }

        max[0]=Math.max(max[0],Math.max(left,Math.max(right, all3)));
        
        int currmax=0;
        
        if(left!=Integer.MIN_VALUE && right!=Integer.MIN_VALUE){
           currmax= Math.max(root.val+left, Math.max(root.val+right,root.val));
        }
        else if(right!=Integer.MIN_VALUE && left==Integer.MIN_VALUE){
            currmax=Math.max(root.val,root.val+right);
        }
        else if(right==Integer.MIN_VALUE && left!=Integer.MIN_VALUE){
            currmax=Math.max(root.val,root.val+left);
        }
        else{
            currmax= root.val ;
        }
       return currmax;
    }
}
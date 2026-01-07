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
    long maxprod;
    int mod=1000000007;

    public int maxProduct(TreeNode root) {
        long totalsum=0;
        totalsum=getsum(root);
        maxprod=0;
        prod(root,totalsum);
        return (int)(maxprod%mod);
    }
    public long prod(TreeNode root, long totalsum){
        if(root==null){
            return 0;
        }
        long left=prod(root.left, totalsum);
        long right=prod(root.right, totalsum);

        long currsum=left+right+root.val;
        long othersum=totalsum-currsum;
        long currprod=(1L*currsum*othersum);
        maxprod=Math.max(maxprod, currprod);
        // maxprod%=mod;

        return currsum;
    }
    public long getsum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+getsum(root.left)+getsum(root.right);
    }
}
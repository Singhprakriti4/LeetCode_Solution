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
    int pathsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        height(root);
        return pathsum;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftpath=height(root.left);
        int rightpath=height(root.right);

        // System.out.println(leftpath);
        // System.out.println(rightpath);

        //three cases
        
        //case 1
       int opt1=root.val+leftpath;
       int opt2=root.val+rightpath;
       int opt3=root.val+leftpath+rightpath;
       int opt4=root.val;
    //    System.out.println("root : "+root.val+"  "+opt1+"  "+opt2+"  "+opt3);

        int currmax=Math.max(opt1,Math.max(Math.max(opt2,opt3),opt4));
        pathsum=Math.max(pathsum, currmax);

        //pass the maximum of option 1 and 2
        //cuz root can either be a path node or the root node
        //but we can only pass above the path condition of root node

        return Math.max(Math.max(leftpath, rightpath)+root.val, opt4);
    }
}
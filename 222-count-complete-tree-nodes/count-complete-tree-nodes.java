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
    //less than order of n

    public int countNodes(TreeNode root) {
        return func(root);
    }
    public int func(TreeNode root){
        if(root==null){
            return 0;
        }
        //  height of left subtree(left and right)
       int ans=1;

       int llh= height(root.left,-1);
       int lrh= height(root.left,1);

       int rlh=height(root.right,-1);
       int rrh=height(root.right,1);

       if((llh==lrh) && (rrh==rlh)){
        //both are balanced
        ans=ans+(int)((int)Math.pow(2,llh)-1) +(int) ((int)Math.pow(2,rlh)-1);
       }
       else if(llh!=lrh){
        ans=ans+((int)Math.pow(2,rlh)-1)+func(root.left);
       }
       else{
        ans=ans+(int)((int)Math.pow(2,llh)-1)+func(root.right);
       }
      return ans;
    }

    public int height(TreeNode root,int path){
        //path=-1--> left
        //path=1--> right
        if(root==null){
            return 0;
        }
        
        if(path==-1){
           return 1+ height(root.left,-1);
        }
           return 1+ height(root.right,1);
    }
}
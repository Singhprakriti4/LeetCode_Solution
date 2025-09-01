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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder,inorder, 0, inorder.length-1);

    }
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){

        if(end-start<0 || index>=preorder.length ){
            return null;
        }

        //create the root
        TreeNode root=new TreeNode(preorder[index]);

        //split the sets
        int partition=-1;
        for(int i=start;i<=end;i++){
            if(inorder[i]==preorder[index]){
                partition=i;
                break;
            }
        }
        index+=1;
        root.left=helper(preorder,inorder, start, partition-1);
        root.right=helper(preorder, inorder, partition+1, end);
        
        //return root
        return root;
    }
}
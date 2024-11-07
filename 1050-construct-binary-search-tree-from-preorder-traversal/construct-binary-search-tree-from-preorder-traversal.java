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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0){
            return null;
        }
       TreeNode root= new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
           insert(root,preorder[i]) ;
        }
        return root;
    }
  public TreeNode insert(TreeNode root,int key){
    if(root==null){
        return new TreeNode(key);
    }
    if(root.val>key){
        root.left=insert(root.left,key);
    }
    if(root.val<key){
        root.right=insert(root.right,key);
    }

    return root;
  }
}

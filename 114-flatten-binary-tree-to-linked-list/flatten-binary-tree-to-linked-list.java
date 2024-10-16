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
    public void flatten(TreeNode root) {
      List<TreeNode> nodes=new ArrayList<>();
      if(root!=null)
      TreeNode_flat(root,nodes);
    }
    public void TreeNode_flat(TreeNode root,List<TreeNode> nodes){
        if(root.left==null && root.right==null && nodes.size()==0){
            return;
        }
        if(root.left==null && root.right==null){
            root.right=nodes.get(0);
            nodes.remove(0);
            TreeNode_flat(root.right,nodes);
        }
        else{
            if(root.left==null){
                TreeNode_flat(root.right,nodes);
            }
            else if(root.right==null){
                root.right=root.left;
                root.left=null;
                TreeNode_flat(root.right,nodes);
            }
            else{
                nodes.add(0,root.right);
                root.right=root.left;
                root.left=null;
                TreeNode_flat(root.right,nodes);
            }
        }
    }
}
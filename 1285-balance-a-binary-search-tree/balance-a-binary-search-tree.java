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
 //reconstruction
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        //inorder traversal-> sorted
        List<TreeNode> sorted=new ArrayList<>();
        inorder(sorted, root);
        return binary(sorted, 0, sorted.size()-1);
    }
    public TreeNode binary(List<TreeNode> list, int s, int e){
        if(s>e || s>=list.size() || e<0){
            return null;
        }
        int mid=s+(e-s)/2;
        TreeNode node=list.get(mid);
        node.left=binary(list, s, mid-1);
        node.right=binary(list, mid+1, e);

        return node;
    }
    public void inorder(List<TreeNode> sorted, TreeNode root){
        if(root==null){
            return ;
        }
        if(root.left!=null){
            inorder(sorted, root.left);
        }
        sorted.add(root);
        if(root.right!=null){
            inorder(sorted, root.right);
        }
        root.left=null;
        root.right=null;
        return;
    }
}